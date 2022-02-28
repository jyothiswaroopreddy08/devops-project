package pack;

import static org.junit.Assert.*;

import org.junit.Test;

public class Tester {

	@Test
	public void test() {
		Addition a=new Addition();
			int actual=a.sum(20, 40);
			int expected=60;
			
			assertEquals(expected, actual);
		}
		
		@Test
		public void test1() {
			Addition a=new Addition();
			
			int actual=a.sum(25, 40);
			int expected=65;
			
			assertEquals(expected, actual);
		}
	}

