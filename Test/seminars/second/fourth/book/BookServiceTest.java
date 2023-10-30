package seminars.second.fourth.book;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.seminars.fourth.book.Book;
import org.seminars.fourth.book.BookRepository;
import org.seminars.fourth.book.BookService;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

class BookServiceTest {
    @Mock
    private BookRepository bookRepository;

    private BookService bookService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        bookService = new BookService(bookRepository);
    }

    @Test
    public void testFindBookById_ExistingBookId_ReturnsBook() {
        // Arrange
        String bookId = "1";
        Book expectedBook = new Book(bookId, "Book1", "Author1");
        when(bookRepository.findById(bookId)).thenReturn(expectedBook);

        // Act
        Book actualBook = bookService.findBookById(bookId);

        // Assert
        Assertions.assertNotNull(actualBook);
        Assertions.assertEquals(expectedBook, actualBook);
        verify(bookRepository, times(1)).findById(bookId);
    }

    @Test
    public void testFindBookById_NonexistentBookId_ReturnsNull() {
        // Arrange
        String bookId = "3";
        when(bookRepository.findById(bookId)).thenReturn(null);

        // Act
        Book actualBook = bookService.findBookById(bookId);

        // Assert
        Assertions.assertNull(actualBook);
        verify(bookRepository, times(1)).findById(bookId);
    }

    @Test
    public void testFindAllBooks_ExistingBooks_ReturnsAllBooks() {
        // Arrange
        Book book1 = new Book("1", "Book1", "Author1");
        Book book2 = new Book("2", "Book2", "Author2");
        List<Book> expectedBooks = Arrays.asList(book1, book2);
        when(bookRepository.findAll()).thenReturn(expectedBooks);

        // Act
        List<Book> actualBooks = bookService.findAllBooks();

        // Assert
        Assertions.assertEquals(expectedBooks.size(), actualBooks.size());
        Assertions.assertEquals(expectedBooks, actualBooks);
        verify(bookRepository, times(1)).findAll();
    }

    @Test
    public void testFindAllBooks_NoBooks_ReturnsEmptyList() {
        // Arrange
        List<Book> expectedBooks = Arrays.asList();
        when(bookRepository.findAll()).thenReturn(expectedBooks);

        // Act
        List<Book> actualBooks = bookService.findAllBooks();

        // Assert
        Assertions.assertTrue(actualBooks.isEmpty());
        verify(bookRepository, times(1)).findAll();
    }
}

