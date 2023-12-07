package seminars.fourth.book;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    private BookService bookService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        bookService = new BookService(bookRepository);
    }

    @Test
    void findBookById_WhenBookExists() {
        // Arrange
        String bookId = "123";
        Book mockBook = new Book(bookId, "Mockito in Action", "Unknown");
        when(bookRepository.findById(bookId)).thenReturn(mockBook);

        // Act
        Book result = bookService.findBookById(bookId);

        // Assert
        assertNotNull(result);
        assertEquals(bookId, result.getId());
        assertEquals("Mockito in Action", result.getTitle());
    }

    @Test
    void findAllBooks_WhenCalled_ReturnsAllBooks() {
        // Arrange
        List<Book> mockBooks = Arrays.asList(
                new Book("123", "Mockito in Action", "Unknown"),
                new Book("456", "JUnit 5 in Action", "Unknown")
        );
        when(bookRepository.findAll()).thenReturn(mockBooks);

        // Act
        List<Book> result = bookService.findAllBooks();

        // Assert
        assertNotNull(result);
        assertEquals(2, result.size());
    }
}