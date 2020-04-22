package EnesFramework;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import reportGenerator.ExtentTestManager;
import utilityLibrary.SetUpTest;

public class SearchTest extends SetUpTest {

    //Link them by same custom name
    @Test(dataProvider = "ST_1000_searchItemCategory")
    public void ST_1000(String searchTerm, int testCaseID){
        ExtentTestManager.startTest("ST_1000", "Testing for SIT_1000");
        util.wait(2);
        System.out.println("Sign In class works!");
        HP.verifyHomePage();
        HP.fillSearchBox(searchTerm);
        HP.clickSearchButton();
        PLP.verifyCorrectProduct(searchTerm);
        for (String temp: PLP.getProductName()){
            if (temp.toLowerCase().contains(searchTerm)){
                System.out.println(temp);
            }else {
                Assert.fail("Product name doesn't contain " + searchTerm + " != " + temp);
            }
        }
    }

    @DataProvider(name = "ST_1000_searchItemCategory")
    public Object[] testData(){
        return new Object[][]{  //To test with different
                {"camera", 1000},
                {"toys", 1001},
                {"computer", 1002}
        };

//        return new Object[]{
//                "camera",
//                "Toys",
//                "Computer",
//        };
    }



    //Link them buy putting method name
    @Test(dataProvider = "testData2")
    public void AP_1011(String searchItem, String errorMessage, int index){
        System.out.println("This is " + index + " time of teest");
        HP.verifyHomePage();
        HP.fillSearchBox(searchItem);
        HP.clickSearchButton();
        PLP.verifyCorrectProduct(searchItem);
        for (String temp: PLP.getProductName()){
            if (temp.toLowerCase().contains(searchItem)){
                System.out.println(temp);
            }else {
                Assert.fail(errorMessage);
            }
        }
    }

    @DataProvider
    public Object[] testData2() {
        return new Object[][]{  //To test with different
                {"camera", "errorMessage", 1},
                {"toys", "errorMessage", 2},
                {"computer", "errorMessage", 3}
        };
    }

}
