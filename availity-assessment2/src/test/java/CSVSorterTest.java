package test.java;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.java.CSVSorter;

class CSVSorterTest {
	CSVSorter sorter = new CSVSorter();
	
	@Test
	void test() {
		sorter.extractor("src/main/resources/InsuranceInput.csv");
	}

}
