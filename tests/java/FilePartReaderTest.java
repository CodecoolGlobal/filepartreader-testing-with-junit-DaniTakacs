import org.junit.jupiter.api.Test;

import java.io.IOException;

import com.codecool.danitakacs.FilePartReader;

import static org.junit.jupiter.api.Assertions.*;

class FilePartReaderTest {

    FilePartReader filePartReader = new FilePartReader();

    @Test
    public void testReadsAll() throws IOException {
        filePartReader.setup("tests/resources/test_0.txt", 1, 1);
        String fileContent = "I am not a mortal - said Illidan.\n" +
                "Anything that can be killed is mortal.";
        assertEquals(fileContent, filePartReader.read());
    }

    @Test
    public void testReadsFromLineToLine() throws IOException {
        filePartReader.setup("tests/resources/test_0.txt", 1, 1);
        String expected = "I am not a mortal - said Illidan.";
        assertEquals(expected, filePartReader.readLines());
    }

    @Test
    public void testSetupThrowsInvalidInput() {
        assertThrows(IllegalArgumentException.class, () -> {
            filePartReader.setup("tests/resources/test_1.txt", 3, 1);
        });
    }

    @Test
    public void testSetupThrowsInvalidInputOnWrongFromLine() {
        assertThrows(IllegalArgumentException.class, () -> {
            filePartReader.setup("tests/resources/test_1.txt", -1, 1);
        });

    }
}