package pruebaJunit;

import org.junit.*;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestAnotaciones {
	
	
	
	@BeforeClass
	public static void beforeClass() {
		System.out.println("beforeClass ");
	}
	@Before
	public void before() {
		System.out.println("before ");
	}	
	
	@Test
	public void A_test1() {
		System.out.println("test 1  ");
	}
	@Test
	public void B_test2() {
		System.out.println("test 2  ");
	}
	@Test
	public void C_test0() {
		System.out.println("test 0  ");
	}		
	@After
	public void after() {
		System.out.println("after ");
	}
	@AfterClass
	public static void afterClass() {
		System.out.println("afterClass ");
	}	

}
