package arrays;

import org.junit.Test;

import static org.junit.Assert.*;

public class NameRepositoryTest
{
    @Test
    public void Add()
    {
        //Arrange
        boolean result1, result2;

        //Act
        result1 = NameRepository.add("Kalle Karlsson");
        result2 = NameRepository.add("Kalle Karlsson");

        //Assert
        assertTrue(result1);
        assertFalse(result2);
    }
    @Test

    public void FindByFirstName()
    {
        //Arrange
        String[] result;

        NameRepository.add("Kalle Karlsson");
        NameRepository.add("Tore Karlsson");
        NameRepository.add("Kalle Larsson");

        //Act
        result = NameRepository.findByFirstName("Kalle");

        //Assert
        assertEquals(2, result.length);
    }
}