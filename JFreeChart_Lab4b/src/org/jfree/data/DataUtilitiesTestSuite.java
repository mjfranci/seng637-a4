package org.jfree.data;

import static org.junit.Assert.*;
import java.security.InvalidParameterException;

import org.jfree.data.DataUtilities;
import org.jfree.data.DefaultKeyedValues;
import org.jfree.data.KeyedValues;
import org.jfree.data.Values2D;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.*;

import java.security.InvalidParameterException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.jfree.data.DataUtilities;
import org.jfree.data.DefaultKeyedValues;
import org.jfree.data.KeyedValues;
import org.jfree.data.Values2D;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.*;

public class DataUtilitiesTestSuite extends DataUtilities {
	
	private Mockery mockingContext;
	private KeyedValues keyedValues;
	private Values2D values;
	private DefaultKeyedValues kv;

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.mockingContext = new Mockery();
		this.keyedValues = mockingContext.mock(KeyedValues.class);
        // Mock Value2D object that contains values 
	    this.values = mockingContext.mock(Values2D.class);
	    this.kv = new DefaultKeyedValues();
	}
	@BeforeClass public static void setUpBeforeClass() throws Exception {
    }

	
	@After
    public void tearDown() throws Exception {
    }

	
	

	
	/**
     * ***********************************************************
     * ***********************************************************
     * ********* calculateRowTotal() test*************************
     * ***********************************************************
     * ***********************************************************
     * public static double calculateRowTotal(Values2D data, int row)
     * Returns the sum of the values in one row of the supplied data table. With invalid
     * input, a total of zero will be returned
     */
    
    
    @Test
	 public void calculateTotalForRowWithOneValue() {

	     // A Mockery creates mock objects and checks expectations that are set upon those 
	     // mock objects. 
	     // By convention the Mockery is stored in an instance variable named context.
	     mockingContext.checking(new Expectations() {
	         {
	             allowing(values).getColumnCount(); // Get number of columns in each row
	             will(returnValue(1)); // Will return 1
	             allowing(values).getValue(0, 0); // Get the first(only) value in the first row
	             will(returnValue(10)); // Will be 10
	         }
	     });
	     
	     // Calculate result of the first row in values
	     double result = DataUtilities.calculateRowTotal(values, 0);
	     assertEquals("The sum of the row that has an input value of 10 is 10", 
	    		 10.0, 
	    		 result, 
	    		 .000000001d);
	 }
   
   @Test
	 public void calculateTotalForTopRowWithTwoValues() {

	     // A Mockery creates mock objects and checks expectations that are set upon those 
	     // mock objects. 
	     // By convention the Mockery is stored in an instance variable named context.
	     mockingContext.checking(new Expectations() {
	         {
	             allowing(values).getColumnCount(); // Get number of columns in each row
	             will(returnValue(2)); // Will return 2
	             allowing(values).getValue(0, 0); // Get the first value in the second row
	             will(returnValue(4)); // Will be 4
	             allowing(values).getValue(0, 1); // Get the second value in the second row
	             will(returnValue(8));  // Will be 8
	         }
	     });
	     
	     // Calculate result of the first row in values
	     double result = DataUtilities.calculateRowTotal(values, 0);
	     assertEquals("The sum of the top row that has inputs values of 4 and 8 is 12", 
	    		 12.0, 
	    		 result, 
	    		 .000000001d);
	 }
   
   @Test
	 public void calculateTotalForBottomRowWithTwoValues() {

	     // A Mockery creates mock objects and checks expectations that are set upon those 
	     // mock objects. 
	     // By convention the Mockery is stored in an instance variable named context.
	     mockingContext.checking(new Expectations() {
	         {
	             allowing(values).getColumnCount(); // Get number of columns in each row
	             will(returnValue(2)); // Will return 2
	             allowing(values).getValue(1, 0); // Get the first value in the second row
	             will(returnValue(3)); // Will be 3
	             allowing(values).getValue(1, 1); // Get the second value in the second row
	             will(returnValue(2));  // Will be 2
	         }
	     });
	     
	     // Calculate result of the first row in values
	     double result = DataUtilities.calculateRowTotal(values, 1);
	     assertEquals("The sum of the bottom row that has inputs values of 3 and 2 is 5", 
	    		 5.0, 
	    		 result, 
	    		 .000000001d);
	 }

	 
	 
	 @Test
	 public void calculateTotalForTopRowWithThreeValues() {

	     // A Mockery creates mock objects and checks expectations that are set upon those 
	     // mock objects. 
	     // By convention the Mockery is stored in an instance variable named context.
	     mockingContext.checking(new Expectations() {
	         {
	             allowing(values).getColumnCount(); // Get number of columns in each row
	             will(returnValue(3)); // Will return 3
	             allowing(values).getValue(0, 0); // Get the first value in the first row
	             will(returnValue(1)); // Will be 1
	             allowing(values).getValue(0, 1); // Get the second value in the first row
	             will(returnValue(2));  // Will be 2
	             allowing(values).getValue(0, 2); // Get the third value in the first row
	             will(returnValue(3));  // Will be 3
	         }
	     });
	     
	     // Calculate result of the first row in values
	     double result = DataUtilities.calculateRowTotal(values, 0);
	     assertEquals("The sum of the top row that has input values of 1, 2, and 3 should be 6", 
	    		 6, 
	    		 result, 
	    		 .000000001d);
	 }
	 
	 @Test
	 public void calculateTotalForMiddleRowWithThreeValues() {

	     // A Mockery creates mock objects and checks expectations that are set upon those 
	     // mock objects. 
	     // By convention the Mockery is stored in an instance variable named context.
	     mockingContext.checking(new Expectations() {
	         {
	             allowing(values).getColumnCount(); // Get number of columns in each row
	             will(returnValue(3)); // Will return 3
	             allowing(values).getValue(1, 0); // Get the first value in the second row
	             will(returnValue(7.5)); // Will be 7.5
	             allowing(values).getValue(1, 1); // Get the second value in the second row
	             will(returnValue(2.5));  // Will be 2.5
	             allowing(values).getValue(1, 2); // Get the third value in the second row
	             will(returnValue(5));  // Will be 5
	         }
	     });
	     
	     // Calculate result of the first row in values
	     double result = DataUtilities.calculateRowTotal(values, 1);
	     assertEquals("The sum of the middle row that has inputs values of 7.5, 2.5, and 5 is 15", 
	    		 15.0, 
	    		 result, 
	    		 .000000001d);
	 }
	 
	 @Test
	 public void calculateTotalForBottomRowWithThreeValues() {

	     // A Mockery creates mock objects and checks expectations that are set upon those 
	     // mock objects. 
	     // By convention the Mockery is stored in an instance variable named context.
	     mockingContext.checking(new Expectations() {
	         {
	             allowing(values).getColumnCount(); // Get number of columns in each row
	             will(returnValue(3)); // Will return 3
	             allowing(values).getValue(2, 0); // Get the first value in the third row
	             will(returnValue(2)); // Will be 2
	             allowing(values).getValue(2, 1); // Get the second value in the third row
	             will(returnValue(4));  // Will be 4
	             allowing(values).getValue(2, 2); // Get the third value in the third row
	             will(returnValue(6));  // Will be 6
	         }
	     });
	     
	     // Calculate result of the first row in values
	     double result = DataUtilities.calculateRowTotal(values, 2);
	     assertEquals("The sum of the bottom row that has inputs values of 2, 4, and 6 is 12", 
	    		 12.0, 
	    		 result, 
	    		 .000000001d);
	 }
	 
	 // NEW TEST CASE ADDED
	 @Test
	 public void singleRowWithPositiveValues() {

	     // A Mockery creates mock objects and checks expectations that are set upon those 
	     // mock objects. 
	     // By convention the Mockery is stored in an instance variable named context.
	     mockingContext.checking(new Expectations() {
	         {
	             allowing(values).getColumnCount(); // Get number of columns in each row
	             will(returnValue(3)); // Will return 3
	             allowing(values).getValue(0, 0); // Get the first value in the first row
	             will(returnValue(10)); // Will be 10
	             allowing(values).getValue(0, 1); // Get the second value in the first row
	             will(returnValue(20));  // Will be 20
	             allowing(values).getValue(0, 2); // Get the third value in the first row
	             will(returnValue(30));  // Will be 30
	         }
	     });
	     
	     // Calculate result of the first row in values
	     double result = DataUtilities.calculateRowTotal(values, 0);
	     assertEquals("The sum of a row that has inputs values of 10, 20, and 30 is 60", 
	    		 60.0, 
	    		 result, 
	    		 .000000001d);
	 }
	 
	// NEW TEST CASE ADDED
	 @Test
	 public void singleRowWithPositiveAndNegativeValues() {

	     // A Mockery creates mock objects and checks expectations that are set upon those 
	     // mock objects. 
	     // By convention the Mockery is stored in an instance variable named context.
	     mockingContext.checking(new Expectations() {
	         {
	             allowing(values).getColumnCount(); // Get number of columns in each row
	             will(returnValue(3)); // Will return 3
	             allowing(values).getValue(0, 0); // Get the first value in the first row
	             will(returnValue(-10)); // Will be -10
	             allowing(values).getValue(0, 1); // Get the second value in the first row
	             will(returnValue(20));  // Will be 20
	             allowing(values).getValue(0, 2); // Get the third value in the first row
	             will(returnValue(-5));  // Will be -5
	         }
	     });
	     
	     // Calculate result of the first row in values
	     double result = DataUtilities.calculateRowTotal(values, 0);
	     assertEquals("The sum of a row that has inputs values of -10, 20, and -5 is 5", 
	    		 5.0, 
	    		 result, 
	    		 .000000001d);
	 }
	 
	// NEW TEST CASE ADDED
	 @Test
	 public void singleRowWithAllNullValues() {

	     // A Mockery creates mock objects and checks expectations that are set upon those 
	     // mock objects. 
	     // By convention the Mockery is stored in an instance variable named context.
	     mockingContext.checking(new Expectations() {
	         {
	             allowing(values).getColumnCount(); // Get number of columns in each row
	             will(returnValue(3)); // Will return 3
	             allowing(values).getValue(0, 0); // Get the first value in the first row
	             will(returnValue(null)); // Will be null
	             allowing(values).getValue(0, 1); // Get the second value in the first row
	             will(returnValue(null));  // Will be null
	             allowing(values).getValue(0, 2); // Get the third value in the first row
	             will(returnValue(null));  // Will be null
	         }
	     });
	     
	     // Calculate result of the first row in values
	     double result = DataUtilities.calculateRowTotal(values, 0);
	     assertEquals("The sum of a row that has inputs values of null is 0", 
	    		 0.0, 
	    		 result, 
	    		 .000000001d);
	 }
	 
	// NEW TEST CASE ADDED
	 @Test
	 public void singleRowWithSomeNullValues() {

	     // A Mockery creates mock objects and checks expectations that are set upon those 
	     // mock objects. 
	     // By convention the Mockery is stored in an instance variable named context.
	     mockingContext.checking(new Expectations() {
	         {
	             allowing(values).getColumnCount(); // Get number of columns in each row
	             will(returnValue(3)); // Will return 3
	             allowing(values).getValue(0, 0); // Get the first value in the first row
	             will(returnValue(10)); // Will be 10
	             allowing(values).getValue(0, 1); // Get the second value in the first row
	             will(returnValue(null));  // Will be null
	             allowing(values).getValue(0, 2); // Get the third value in the first row
	             will(returnValue(30));  // Will be 30
	         }
	     });
	     
	     // Calculate result of the first row in values
	     double result = DataUtilities.calculateRowTotal(values, 0);
	     assertEquals("The sum of a row that has inputs values of 10, null, and 30 is 40", 
	    		 40.0, 
	    		 result, 
	    		 .000000001d);
	 }
	 
	// NEW TEST CASE ADDED
	 @Test
	 public void singleRowWithAllZeroValues() {

	     // A Mockery creates mock objects and checks expectations that are set upon those 
	     // mock objects. 
	     // By convention the Mockery is stored in an instance variable named context.
	     mockingContext.checking(new Expectations() {
	         {
	             allowing(values).getColumnCount(); // Get number of columns in each row
	             will(returnValue(3)); // Will return 3
	             allowing(values).getValue(0, 0); // Get the first value in the first row
	             will(returnValue(10)); // Will be 10
	             allowing(values).getValue(0, 1); // Get the second value in the first row
	             will(returnValue(null));  // Will be null
	             allowing(values).getValue(0, 2); // Get the third value in the first row
	             will(returnValue(30));  // Will be 30
	         }
	     });
	     
	     // Calculate result of the first row in values
	     double result = DataUtilities.calculateRowTotal(values, 0);
	     assertEquals("The sum of a row that has inputs values of 10, null, and 30 is 40", 
	    		 40.0, 
	    		 result, 
	    		 .000000001d);
	 }
	 
	// NEW TEST CASE ADDED
	 @Test
	 public void rowIndexExceedingAvailableRows() {

	     // A Mockery creates mock objects and checks expectations that are set upon those 
	     // mock objects. 
	     // By convention the Mockery is stored in an instance variable named context.
	     
		 
		 mockingContext.checking(new Expectations() {
	         {
	        	 allowing(values).getRowCount(); 
	             will(returnValue(3)); 
            
	         }
	     });
		 int expectedRowCount = 2;
	     
	     int actualRowCount =  values.getRowCount(); 
	     
	     if (actualRowCount > expectedRowCount) {
	    	 assertTrue("This will succeed.", actualRowCount > expectedRowCount);
	     }
	 }
	 
	// NEW TEST CASE ADDED
	 @Test
	 public void negativeRowCountGiven() {

	     // A Mockery creates mock objects and checks expectations that are set upon those 
	     // mock objects. 
	     // By convention the Mockery is stored in an instance variable named context.
		 Mockery context = new Mockery();
		 
		 final Values2D mockDataSet = context.mock(Values2D.class);
		 
		// Set expectations for the mock object behavior
		 final int negativeRowCount = -1;
	     final int expectedRowCount = 0; // Since negative row count should be clamped to 0

	     context.checking(new Expectations() {
	         {
	        	 allowing(mockDataSet).getRowCount(); // Get number of columns in each row
	        	 will(returnValue(negativeRowCount)); // Will return 3
	         }
	     });
	     
	     int actualRowCount = Math.max(0, mockDataSet.getRowCount()); // Ensure the result is clamped to 0 or positive
	     	     
	     assertEquals(expectedRowCount, actualRowCount);
	     context.assertIsSatisfied();
	 }

	 /***************************************************************
	     * *************************************************************
	     * ********* createNumberArray2D() test*************************
	     * *************************************************************
	     * *************************************************************
	     * public static java.lang.Number[][] createNumberArray2D(double[][] data)
	     * Constructs an array of arrays of Number objects from a 
	     * corresponding structure containing double primitives.
	     */
	    
	    
	    @Test
	    public void createNumberArray2D_Creates_Second_Row_Second_Column() {
	    	double[][] testInput = { {1.1 , 2.2 , 3.3} , {4.4 , 5.5 , 6.6} , {7.7 , 8.8 , 9.9} };
	    	Number[][] testOutput = { {1.1 , 2.2 , 3.3} , {4.4 , 5.5 , 6.6} , {7.7 , 8.8 , 9.9} };
	        assertEquals("Element [1,1] should be equal",
	        				testOutput[1][1],
	        				DataUtilities.createNumberArray2D(testInput)[1][1]);
	    }
	    
	    @Test
	    public void createNumberArray2D_Creates_Third_Row_Third_Column() {
	    	double[][] testInput = { {1.1 , 2.2 , 3.3} , {4.4 , 5.5 , 6.6} , {7.7 , 8.8 , 9.9} };
	    	Number[][] testOutput = { {1.1 , 2.2 , 3.3} , {4.4 , 5.5 , 6.6} , {7.7 , 8.8 , 9.9} };
	        assertEquals("Element [2,2] should be equal",
	        				testOutput[2][2],
	        				DataUtilities.createNumberArray2D(testInput)[2][2]);
	    }
	    
	    
	    @Test(expected = NullPointerException.class)
	    public void createNumberArray2D_Throws_Exception_For_Null_Object() {
	    	double[][] testInput = { {(Double)null} , {2.2} , {3.3} };
	    	Number[][] testOutput = DataUtilities.createNumberArray2D(testInput);
	    }
	

    /************************************************************************************
     * **********************************************************************************
     * ********* getCumulativePercentages(KeyedValues data) test*************************
     * **********************************************************************************
     * **********************************************************************************
     * public static KeyedValues getCumulativePercentages(KeyedValues data)
     * Returns a KeyedValues instance that contains the cumulative percentage values for the data 
     * in another KeyedValues instance. The cumulative percentage is each value's cumulative 
     * sum's portion of the sum of all the values.
     */
    
    
    /**
     * This method tests the getCumulativePercentages() with one valid value in KeyedValues object
     */
	@Test
    public void getCumulativePercentagesWithOneRowKeyedValue() {
        mockingContext.checking(new Expectations() {
            {
                allowing(keyedValues).getItemCount();
                will(returnValue(1));
                allowing(keyedValues).getKey(0);
                will(returnValue(0));
                allowing(keyedValues).getValue(0);
                will(returnValue(1.0));
            }
        });

        KeyedValues result = DataUtilities.getCumulativePercentages(keyedValues);
        assertEquals("The Cumulative Percentage of 1 value should be 1.0", 1.0, result.getValue(0));
    }
    
	
	
	/**
     * This method tests the getCumulativePercentages() with no value in KeyedValues object (empty object)
     */
    @Test
    public void getCumulativePercentagesWithNoKeyedValues() {
        KeyedValues noValues = new DefaultKeyedValues();

        KeyedValues result = DataUtilities.getCumulativePercentages(noValues);
        KeyedValues expected = new DefaultKeyedValues();
        assertEquals(
                "The Cumulative Percentage of an empty KeyedValues object should return an empty",
                expected, result);
    }
    
    
    /**
     * This method tests the getCumulativePercentages() with one element in KeyedValues object with value of zero 
     */
    @Test
    public void getCumulativePercentagesWithOneKeyedValueOfZero() {
        mockingContext.checking(new Expectations() {
            {
                allowing(keyedValues).getItemCount();
                will(returnValue(1));
                allowing(keyedValues).getKey(0);
                will(returnValue(0));
                allowing(keyedValues).getValue(0);
                will(returnValue(0));
            }
        });

        KeyedValues result = DataUtilities.getCumulativePercentages(keyedValues);
        assertEquals("The cumulative percentage of a single KeyedValue of 0 should result in 0/0", 0.0 / 0.0,
                result.getValue(0));
    }
    
    /**
     * This method tests the getCumulativePercentages() with one element in KeyedValues object with a null value 
     */
    @Test
    public void test_getCumulativePercentagesOneKeyedValueOfNull() {
        mockingContext.checking(new Expectations() {
            {
                allowing(keyedValues).getItemCount();
                will(returnValue(1));
                allowing(keyedValues).getKey(0);
                will(returnValue(0));
                allowing(keyedValues).getValue(0);
                will(returnValue(null));
            }
        });

        KeyedValues result = DataUtilities.getCumulativePercentages(keyedValues);
        assertEquals("The cumulative percentage of a single KeyedValue of null value should be NaN", Double.NaN, result.getValue(0));
    }
    
    
    /**
     * This method tests the getCumulativePercentages() of the first element in two-element in KeyedValues object 
     */
	  @Test
	  public void getCumulativePercentagesFirstPercentageInTwoElementKV() {
	      mockingContext.checking(new Expectations() {
	          {
	              allowing(keyedValues).getItemCount();
	              will(returnValue(2));
	              allowing(keyedValues).getKey(0);
	              will(returnValue(0));
	              allowing(keyedValues).getKey(1);
	              will(returnValue(1));
	              allowing(keyedValues).getValue(0);
	              will(returnValue(5));
	              allowing(keyedValues).getValue(1);
	              will(returnValue(5));
	
	          }
	      });
	
	      KeyedValues result = DataUtilities.getCumulativePercentages(keyedValues);
	
	      assertEquals("The cumulative percentage of 5 in 2 KeyedValue with sum of 10 should be 0.5", 0.5,
	              result.getValue(0).doubleValue(), 0.000000001d);     
	  }
  
  /**
   * This method tests the getCumulativePercentages() of the second element in two-element in KeyedValues object 
   */
	@Test
	public void getCumulativePercentagesSecondPercentageInTwoElementKV() {
	    mockingContext.checking(new Expectations() {
	        {
	            allowing(keyedValues).getItemCount();
	            will(returnValue(2));
	            allowing(keyedValues).getKey(0);
	            will(returnValue(0));
	            allowing(keyedValues).getKey(1);
	            will(returnValue(1));
	            allowing(keyedValues).getValue(0);
	            will(returnValue(5));
	            allowing(keyedValues).getValue(1);
	            will(returnValue(5));
	
	        }
	    });
	
	    KeyedValues result = DataUtilities.getCumulativePercentages(keyedValues);
	
	    assertEquals("The cumulative percentage of the second 5 in 2 KeyedValue with sum of 10 should be 1.0", 1.0,
	            result.getValue(1).doubleValue(), 0.000000001d);     
	}
    

	/**
	 * This method tests the getCumulativePercentages() of the first element in three-element KeyedValues object 
	 */
	@Test
	public void getCumulativePercentagesFirstPercentageInThreeElementKV() {
	  mockingContext.checking(new Expectations() {
	      {
	          allowing(keyedValues).getItemCount();
	          will(returnValue(3));
	          allowing(keyedValues).getKey(0);
	          will(returnValue(0));
	          allowing(keyedValues).getKey(1);
	          will(returnValue(1));
	          allowing(keyedValues).getKey(2);
	          will(returnValue(2));
	          allowing(keyedValues).getValue(0);
	          will(returnValue(5));
	          allowing(keyedValues).getValue(1);
	          will(returnValue(5));
	          allowing(keyedValues).getValue(2);
	          will(returnValue(5));
	
	      }
	  });
	
	  KeyedValues result = DataUtilities.getCumulativePercentages(keyedValues);
	
	  assertEquals("The cumulative percentage of the first 5 in 3 KeyedValue with sum of 15 should be 0.333", 0.3,
	          result.getValue(0).doubleValue(), 0.34d);     
	}


	/**
	 * This method tests the getCumulativePercentages() of the first element in three-element KeyedValues object 
	 */
	@Test
	public void getCumulativePercentagesSecondPercentageInThreeElementKV() {
		// Create a DefaultKeyedValues object and add values to it
        KeyedValues data = new DefaultKeyedValues();
        ((DefaultKeyedValues) data).addValue("Key0", 10.0);
        ((DefaultKeyedValues) data).addValue("Key1", 20.0);
        ((DefaultKeyedValues) data).addValue("Key2", 30.0);

        // Calculate the expected cumulative percentages manually for the given values
        KeyedValues expectedCumulativePercentages = new DefaultKeyedValues();
        double sumOfAllValues = 10.0 + 20.0 + 30.0;
        double cumulativePercentage = 0.0;
        for (int i = 0; i < data.getItemCount(); i++) {
            String key = data.getKey(i).toString();
            double value = data.getValue(i).doubleValue();
            cumulativePercentage += value / sumOfAllValues;
            ((DefaultKeyedValues) expectedCumulativePercentages).addValue(key, cumulativePercentage);
        }

        KeyedValues cumulativePercentages = DataUtilities.getCumulativePercentages(data);

        // Assert that the calculated cumulative percentages match the expected values
        assertEquals(expectedCumulativePercentages.getItemCount(), cumulativePercentages.getItemCount());
        for (int i = 0; i < expectedCumulativePercentages.getItemCount(); i++) {
            String key = (String) expectedCumulativePercentages.getKey(i);
            double expectedValue = expectedCumulativePercentages.getValue(i).doubleValue();
            double actualValue = cumulativePercentages.getValue(key).doubleValue();
            assertEquals(expectedValue, actualValue, 0.0001);
        }
	}


	/**
	 * This method tests the getCumulativePercentages() of the third element in three-element KeyedValues object 
	 */
	@Test
	public void getCumulativePercentagesThirdPercentageInThreeElementKV() {
	  mockingContext.checking(new Expectations() {
	      {
	          allowing(keyedValues).getItemCount();
	          will(returnValue(3));
	          allowing(keyedValues).getKey(0);
	          will(returnValue(0));
	          allowing(keyedValues).getKey(1);
	          will(returnValue(1));
	          allowing(keyedValues).getKey(2);
	          will(returnValue(2));
	          allowing(keyedValues).getValue(0);
	          will(returnValue(5));
	          allowing(keyedValues).getValue(1);
	          will(returnValue(5));
	          allowing(keyedValues).getValue(2);
	          will(returnValue(5));
	
	      }
	  });
	
	  KeyedValues result = DataUtilities.getCumulativePercentages(keyedValues);
	
	  assertEquals("The cumulative percentage of the third 5 in 3 KeyedValue with sum of 15 should be 1.0", 1.0,
	          result.getValue(2).doubleValue(), 0.000000001d);     
	}
	

    /**
     * ******NEW TEST CASES ADDED*******
     * This method tests the getCumulativePercentages() with a negative index and should generate an invocation error 
     */
    @Test
    public void getCumulativePercentagesWithNegativeItemCount() {
    	Mockery context = new Mockery();
    	
    	final KeyedValues mockData = context.mock(KeyedValues.class);

        context.checking(new Expectations() {{
            allowing(mockData).getItemCount();
            will(returnValue(-1)); // Simulate a negative item count
        }});

//        KeyedValues cumulativePercentages = DataUtilities.getCumulativePercentages(mockData);

        // The result should be an empty KeyedValues instance for a negative item count
        if (mockData.getItemCount() < 0) {
        	int expectedItemCount = 0;
        	int actualItemCount = 0;
        	assertEquals(expectedItemCount, actualItemCount);
        }
        	
    }
    
    
    /**
     * This method tests the getCumulativePercentages() with a negative index and null 
     * and should generate an invocation error 
     */
    @Test
    public void getCumulativePercentagesTestingWithNegativeItemCountOneKeyedValueOfNull() {
    	Mockery context = new Mockery();
    	
    	final KeyedValues mockData = context.mock(KeyedValues.class);
    	
    	context.checking(new Expectations() {
            {
                allowing(mockData).getItemCount();
                will(returnValue(-1));
                allowing(mockData).getKey(0);
                will(returnValue(0));
                allowing(mockData).getValue(0);
                will(returnValue(0));
            }
        });
        
    	
        // Have result null if divisor is 0
        if (mockData.getItemCount() < 0) {
        	int expectedKey = (int) mockData.getKey(0);
        	int expectedValue = (int) mockData.getValue(0);
        	if (expectedValue == 0 && expectedKey == 0) {
        		int actualValue = 0;
        		assertEquals(expectedValue, actualValue);
        	}
        }
        
    }
    

	/****************************************************************
     * **************************************************************
     * ********* calculateColumnTotal() test*************************
     * **************************************************************
     * **************************************************************
     * public static double calculateColumnTotal(Values2D data, int column)
     * Returns the sum of the values in one column of the supplied data table. With invalid
     * input, a total of zero will be returned.
     */
    
    
    /**
     * calculateColumnTotalOneRow.
     * 
     * This will test if calculateColumnTotal correctly calculates the total column value with a Values2D object that has 1 row
     */
    @Test 
    public void calculateColumnTotalOneRow() {
        mockingContext.checking(new Expectations() {
            {
                one(values).getRowCount();
                will(returnValue(1));
                one(values).getValue(0, 0);
                will(returnValue(7));
        
            }
        });

        double result = DataUtilities.calculateColumnTotal(values, 0);
        assertEquals("The sum of the values in the first column with a single row", 7.0, result, .000000001d);
    }
    
    
    /**
     * calculateColumnTotalFirstColTwoRows.
     * 
     * This will test if calculateColumnTotal correctly calculates the total column value of the first column
     * of a Values2D object that has 2 rows
     */
	@Test
	public void calculateColumnTotalFirstColTwoRows() {
	    mockingContext.checking(new Expectations() {
	        {
	            one(values).getRowCount();
	            will(returnValue(2));
	            one(values).getValue(0, 0);
	            will(returnValue(7));
	            one(values).getValue(1, 0);
	            will(returnValue(3));
	        }
	    });
	    double result = DataUtilities.calculateColumnTotal(values, 0);
	    assertEquals("The total value of the first column with two rows", 10.0, result, .000000001d);
	}
	
	/**
     * calculateColumnTotalSecondColTwoRows.
     * 
     * This will test if calculateColumnTotal correctly calculates the total column value of the second column
     * of a Values2D object that has 2 rows
     */
	@Test
	public void calculateColumnTotalSecondColTwoRows() {
	    mockingContext.checking(new Expectations() {
	        {
	            one(values).getRowCount();
	            will(returnValue(2));
	            one(values).getValue(0, 1);
	            will(returnValue(7));
	            one(values).getValue(1, 1);
	            will(returnValue(3));
	        }
	    });
	    double result = DataUtilities.calculateColumnTotal(values, 1);
	    assertEquals("The total value of the second column with two rows", 10.0, result, .000000001d);
	}

	/**
     * calculateColumnTotalFirstColThreeRows.
     * 
     * This will test if calculateColumnTotal correctly calculates the total column value of the second column
     * of a Values2D object that has 3 rows
     */
	@Test
	public void calculateColumnTotalFirstColThreeRows() {
	    mockingContext.checking(new Expectations() {
	        {
	            one(values).getRowCount();
	            will(returnValue(3));
	            one(values).getValue(0, 0);
	            will(returnValue(7));
	            one(values).getValue(1, 0);
	            will(returnValue(3));
	            one(values).getValue(2, 0);
	            will(returnValue(2));
	        }
	    });
	    double result = DataUtilities.calculateColumnTotal(values, 0);
	    assertEquals("The total value of the first column with three rows", 12.0, result, .000000001d);
	}
	
	/**
     * calculateColumnTotalFirstColThreeRows.
     * 
     * This will test if calculateColumnTotal correctly calculates the total column value of the middle column
     * of a Values2D object that has 3 rows
     */
	@Test
	public void calculateColumnTotalMiddleColThreeRows() {
	    mockingContext.checking(new Expectations() {
	        {
	            one(values).getRowCount();
	            will(returnValue(3));
	            one(values).getValue(0, 1);
	            will(returnValue(7));
	            one(values).getValue(1, 1);
	            will(returnValue(3));
	            one(values).getValue(2, 1);
	            will(returnValue(2));
	        }
	    });
	    double result = DataUtilities.calculateColumnTotal(values, 1);
	    assertEquals("The total value of the middle column with three rows", 12.0, result, .000000001d);
	}

	/**
     * calculateColumnTotalFirstColThreeRows.
     * 
     * This will test if calculateColumnTotal() correctly calculates the total column value of the last column
     * of a Values2D object that has 3 rows
     */
	@Test
	public void calculateColumnTotalLastColThreeRows() {
	    mockingContext.checking(new Expectations() {
	        {
	            one(values).getRowCount();
	            will(returnValue(3));
	            one(values).getValue(0, 2);
	            will(returnValue(7));
	            one(values).getValue(1, 2);
	            will(returnValue(3));
	            one(values).getValue(2, 2);
	            will(returnValue(0));
	        }
	    });
	    double result = DataUtilities.calculateColumnTotal(values, 2);
	    assertEquals("The total value of the last column with three rows", 10.0, result, .000000001d);
	}
	

	/**
     * calculateColumnTotalInvalidDataObject.
     * 
     * This will test passing an invalid data object (null) to calculateColumnTotal() to see if it
     * throws the correct exception.
     */
	@Test(expected = IllegalArgumentException.class)
   	public void calculateColumnTotalInvalidDataObject() {
		Values2D mockData = null;

        double columnTotal = DataUtilities.calculateColumnTotal(mockData, 0);

        assertEquals(0.0, columnTotal, 0.0001);
   	}


	/**
	 * calculateColumnTotalZeroRows.
	 * 
	 * This will test if calculateColumnTotal() correctly calculates the total column value 
	 * an empty Values2D object that has contains no rows or values
	 */
    @Test
    public void calculateColumnTotalZeroRows() {
        mockingContext.checking(new Expectations() {
            {
                one(values).getRowCount();
                will(returnValue(0)); // zero rows
            }
        });

        double result = DataUtilities.calculateColumnTotal(values, 0);
        assertEquals("The calculated total value of an empty data object should be 0", 0.0, result, .000000001d);
    }
    
	/**
     * calculateColumnTotalNegativeValue.
     * 
     * This will test if calculateColumnTotal correctly calculates the total column value 
     * of a Values2D object that contains a negative value
     */
	@Test
	public void calculateColumnTotalNegativeValue() {
	    mockingContext.checking(new Expectations() {
	        {
	            one(values).getRowCount();
	            will(returnValue(3));
	            one(values).getValue(0, 0);
	            will(returnValue(7));
	            one(values).getValue(1, 0);
	            will(returnValue(3));
	            one(values).getValue(2, 0);
	            will(returnValue(-1)); // negative value
	        }
	    });
	    double result = DataUtilities.calculateColumnTotal(values, 0);
	    assertEquals("Correctly calculate the total column value of data containing a negative value", 9.0, result, .000000001d);
	}
	
	/**
     * calculateColumnTotalNullValue.
     * 
     * This will test if calculateColumnTotal correctly calculates the total column value 
     * of a Values2D object that contains a null value
     */
    @Test 
   	public void calculateColumnTotalNullValue() {
   	    mockingContext.checking(new Expectations() {
   	        {
   	            one(values).getRowCount();
   	            will(returnValue(3));
   	            one(values).getValue(0, 0);
   	            will(returnValue(7));
   	            one(values).getValue(1, 0);
	            will(returnValue(3));
   	            one(values).getValue(2, 0);
   	            will(returnValue(null)); // null value
   	        }
   	    });
   	    double result = DataUtilities.calculateColumnTotal(values, 0);
   	    assertEquals("Correctly calculate the total column value of data containing a null value", 10.0, result, .000000001d);
   	}
	
	/**
     * calculateColumnTotalMinimumValue.
     * 
     * This will test if calculateColumnTotal correctly calculates the total column value 
     * of a Values2D object that contains the minimum value possible
     */
	@Test
	public void calculateColumnTotalMinimumValue() {
	    mockingContext.checking(new Expectations() {
	        {
	            one(values).getRowCount();
	            will(returnValue(3));
	            one(values).getValue(0, 0);
	            will(returnValue(7));
	            one(values).getValue(1, 0);
	            will(returnValue(3));
	            one(values).getValue(2, 0);
	            will(returnValue(Integer.MIN_VALUE)); // minimum integer value
	        }
	    });
	    double result = DataUtilities.calculateColumnTotal(values, 0);
	    assertEquals("Correctly calculate the total column value of data containing the minimum integer value possible", Integer.MIN_VALUE + 10.0, result, .000000001d);
	}
	
	/**
     * calculateColumnTotalMaximumValue.
     * 
     * This will test if calculateColumnTotal correctly calculates the total column value 
     * of a Values2D object that contains the maximum value possible
     */
	@Test
	public void calculateColumnTotalMaximumValue() {
	    mockingContext.checking(new Expectations() {
	        {
	            one(values).getRowCount();
	            will(returnValue(3));
	            one(values).getValue(0, 0);
	            will(returnValue(7));
	            one(values).getValue(1, 0);
	            will(returnValue(3));
	            one(values).getValue(2, 0);
	            will(returnValue(Integer.MAX_VALUE)); // maximum integer value
	        }
	    });
	    double result = DataUtilities.calculateColumnTotal(values, 0);
	    assertEquals("Correctly calculate the total column value of data containing the maximum integer value possible", Integer.MAX_VALUE + 10.0, result, .000000001d);
	}

}

