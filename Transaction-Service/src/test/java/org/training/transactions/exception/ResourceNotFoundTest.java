package org.training.transactions.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResourceNotFoundTest {

    @Test
    void testResourceNotFoundConstructorWithErrorCodeAndMessage() {
        String errorCode = "RESOURCE_NOT_FOUND";
        String message = "Transaction record not found";
        
        ResourceNotFound exception = new ResourceNotFound(errorCode, message);
        
        assertNotNull(exception);
        assertEquals(errorCode, exception.getErrorCode());
        assertEquals(message, exception.getMessage());
    }

    @Test
    void testResourceNotFoundMessageProperty() {
        String errorCode = "NOT_FOUND";
        String message = "Account details not available";
        
        ResourceNotFound exception = new ResourceNotFound(errorCode, message);
        
        assertTrue(exception.getMessage().contains("Account"));
        assertEquals("Account details not available", exception.getMessage());
    }

    @Test
    void testResourceNotFoundErrorCodeProperty() {
        String errorCode = "ERR_404";
        String message = "Resource not found in database";
        
        ResourceNotFound exception = new ResourceNotFound(errorCode, message);
        
        assertNotNull(exception.getErrorCode());
        assertEquals("ERR_404", exception.getErrorCode());
    }

    @Test
    void testResourceNotFoundExceptionIsRuntimeException() {
        String errorCode = "NOT_FOUND";
        String message = "Test message";
        
        ResourceNotFound exception = new ResourceNotFound(errorCode, message);
        
        assertThrows(RuntimeException.class, () -> {
            throw exception;
        });
    }

    @Test
    void testResourceNotFoundExceptionInheritance() {
        String errorCode = "ERR_001";
        String message = "Test exception";
        
        ResourceNotFound exception = new ResourceNotFound(errorCode, message);
        
        assertTrue(exception instanceof GlobalException);
        assertTrue(exception instanceof RuntimeException);
    }

    @Test
    void testResourceNotFoundWithNullValues() {
        ResourceNotFound exception = new ResourceNotFound(null, null);
        
        assertNotNull(exception);
        assertNull(exception.getErrorCode());
        assertNull(exception.getMessage());
    }

    @Test
    void testResourceNotFoundWithEmptyStrings() {
        String errorCode = "";
        String message = "";
        
        ResourceNotFound exception = new ResourceNotFound(errorCode, message);
        
        assertEquals("", exception.getErrorCode());
        assertEquals("", exception.getMessage());
    }
}
