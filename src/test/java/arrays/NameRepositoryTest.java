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
        boolean result1, result2, result3, result4, result5;
        String[] result;
        String[] expected = new String[] { "Adam Karlsson", "Bella Larsson", "Åke Stenlund", "Örjan Karlsson"  };

        //Act
        result1 = NameRepository.add("öRJAN kARLSSON");
        result2 = NameRepository.add("bella larsson");
        result3 = NameRepository.add("Adam Karlsson");
        result4 = NameRepository.add("adam KARLSSON");
        result5 = NameRepository.add("åke stenlund");

        //Assert
        result = NameRepository.findAll();
        assertArrayEquals(expected, result);
        assertTrue(result1);
        assertTrue(result2);
        assertTrue(result3);
        assertFalse(result4);
        assertTrue(result5);
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
        result = NameRepository.find("tore karlsson");

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
        String[] expected = new String[] { "Kalle Karlsson", "Kalle Larsson", "Tore Karlsson" };

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
        String[] expected = new String[] { "Kalle Karlsson", "Kalle Larsson", "Sture Karlsson" };

        //Act
        result = NameRepository.update("tore karlsson", "sture karlsson");

        //Assert
        assertTrue(result);
        assertArrayEquals(expected, NameRepository.findAll());
    }

    @Test
    public void FindByFirstName()
    {
        //Arrange
        String[] result1, result2;

        NameRepository.add("Kalle Karlsson");
        NameRepository.add("Tore Karlsson");
        NameRepository.add("Kalle Larsson");
        String[] expected1 = new String[] { "Kalle Karlsson", "Kalle Larsson" };
        String[] expected2 = new String[0];

        //Act
        result1 = NameRepository.findByFirstName("kalle");
        result2 = NameRepository.findByFirstName("palle");

        //Assert
        assertArrayEquals(expected1, result1);
        assertArrayEquals(expected2, result2);
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
        result = NameRepository.findByLastName("karlsson");

        //Assert
        assertArrayEquals(expected, result);
    }

    @Test
    public void Remove() {
        //Arrange
        boolean result1, result2;

        NameRepository.add("Kalle Karlsson");
        NameRepository.add("Tore Karlsson");

        //Act
        result1 = NameRepository.remove("tore karlsson");
        result2 = NameRepository.remove("tore karlsson");

        //Assert
        assertTrue(result1);
        assertFalse(result2);
        assertEquals( 1, NameRepository.getSize());
    }
}