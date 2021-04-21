package arrays;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AppTest
{
    @Test
    public void NameRepositoryAdd()
    {
        //Arrange
        boolean result;

        //Act
        result = NameRepository.add("Kalle Karlsson");

        //Assert
        assertTrue(result);
    }
}
