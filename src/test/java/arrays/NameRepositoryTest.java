package arrays;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NameRepositoryTest
{
    @Before
    public void init() {
        NameRepository.clear();
    }

    @Test
    public void GetSize()
    {
        //Arrange
        int result;

        NameRepository.add("Kalle Karlsson");
        NameRepository.add("Tore Karlsson");

        //Act
        result = NameRepository.getSize();

        //Assert
        assertEquals(2, result);
    }

    @Test
    public void Clear() {
        //Arrange
        NameRepository.add("Kalle Karlsson");
        NameRepository.add("Tore Karlsson");

        //Act
        NameRepository.clear();

        //Assert
        assertEquals( 0, NameRepository.getSize());
    }

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
    public void Find()
    {
        //Arrange
        String result;

        NameRepository.add("Kalle Karlsson");
        NameRepository.add("Tore Karlsson");
        NameRepository.add("Kalle Larsson");

        //Act
        result = NameRepository.find("Tore Karlsson");

        //Assert
        assertEquals("Tore Karlsson", result);
    }

    @Test
    public void FindAll()
    {
        //Arrange
        String[] result;

        NameRepository.add("Kalle Karlsson");
        NameRepository.add("Tore Karlsson");
        NameRepository.add("Kalle Larsson");
        String[] expected = new String[] { "Kalle Karlsson", "Tore Karlsson", "Kalle Larsson" };

        //Act
        result = NameRepository.findAll();

        //Assert
        assertArrayEquals(expected, result);
    }

    @Test
    public void Update()
    {
        //Arrange
        boolean result;

        NameRepository.add("Kalle Karlsson");
        NameRepository.add("Tore Karlsson");
        NameRepository.add("Kalle Larsson");
        String[] expected = new String[] { "Kalle Karlsson", "Sture Karlsson", "Kalle Larsson" };

        //Act
        result = NameRepository.update("Tore Karlsson", "Sture Karlsson");

        //Assert
        assertTrue(result);
        assertArrayEquals(expected, NameRepository.findAll());
    }

    @Test
    public void FindByFirstName()
    {
        //Arrange
        String[] result;

        NameRepository.add("Kalle Karlsson");
        NameRepository.add("Tore Karlsson");
        NameRepository.add("Kalle Larsson");
        String[] expected = new String[] { "Kalle Karlsson", "Kalle Larsson" };

        //Act
        result = NameRepository.findByFirstName("Kalle");

        //Assert
        assertArrayEquals(expected, result);
    }

    @Test
    public void FindByLastName()
    {
        //Arrange
        String[] result;

        NameRepository.add("Kalle Karlsson");
        NameRepository.add("Tore Karlsson");
        NameRepository.add("Kalle Larsson");
        String[] expected = new String[] { "Kalle Karlsson", "Tore Karlsson" };

        //Act
        result = NameRepository.findByLastName("Karlsson");

        //Assert
        assertArrayEquals(expected, result);
    }

    @Test
    public void Remove() {
        //Arrange
        NameRepository.add("Kalle Karlsson");
        NameRepository.add("Tore Karlsson");

        //Act
        NameRepository.remove("Tore Karlsson");

        //Assert
        assertEquals( 1, NameRepository.getSize());
    }
}