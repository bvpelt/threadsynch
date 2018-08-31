package bsoft.nl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public class TestBinConverter {
    static final Logger LOGGER = LogManager.getLogger(TestBinConverter.class);

    String input = "0111000101000011101001001111001010101010110001010110010101011001011100100001011010110010100100000101100011011000101010111101010100110001010011010100010110101011010000010100011101001010101010101100101010010101110100000101100110001010010101101010010000100011010001000101011111010010101001001100010101010010010110000100111100111101011010010101001011010101100001001001111011101000010010101001010000111010100111111110101001010010010100001001000101001100101000100011110111101100111110010101011011011100110011101101000010011100110001101000100110001100100100001101101010001110110100010110100011001011110101100100111010111100010100010010101011000101010000101100011001101001011101011001100010010111001111011001001101111110101010010110100110101000101010100110011011010011001110010101000011101110011010100101101000100010011011111001010101010101000111110110000110101011001000001011101011110110110110111011000001110001010010100100010010101101110001001010110111001010101001010011101011011111001011010010110110011010100100111001101100100101010110010010100101001001111101011011110010010101100110110110100111001011111001001111010111001100110100011011010101001010001011010100011011010101010111010101011010101001110101001110101100101101101101111010100010100101100111001100001101100011100101010001010001010010101000011000100101001000111011111000101001000101011000101101000101010010000011010010101011010010100100110001001000111101011100101100100100110001001000101001011101011010100000111000011011010110101110101101101101101001000001100110101001001101010101001011110101101101101001011001100111110011010001100101101000010111001010001110011101001001011000011011010101001101100001011110101010101100101011110100010011000100010011001011001001000100101101001001101101010010101010100110100011001001011001001011100101010010100100100110011101010101011011000010111100101101011100100011011101110000101001010101011000111010000101001100011101110010011010110010010010000110010100111111111111111111111111111111111111111111111111111";

    @Test
    public void convert() {
        String output = "";
        LOGGER.info("input : {}", input);
        BinConverter binConverter = new BinConverter();
        output = binConverter.convert(input);
        LOGGER.info("output: {}", output);
    }

    @Test
    public void conv() {
        String output = "";
        LOGGER.info("input : {}", input);
        BinConverter binConverter = new BinConverter();
        output = binConverter.conv(input);
        LOGGER.info("output: {}", output);
    }
}
