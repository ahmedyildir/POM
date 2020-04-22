package EnesFramework;

import org.testng.annotations.Test;
import reportGenerator.ExtentTestManager;
import utilityLibrary.SetUpTest;

public class SignInTest extends SetUpTest {


    @Test
    public void SIT_1000(){
        ExtentTestManager.startTest("SIT_1000", "Testing for SIT_1000");

        util.wait(2);
        System.out.println("Sign In class works!");
    }

    @Test
    public void SIT_1001(){
        ExtentTestManager.startTest("SIT_1001", "Testing for SIT_1001");
        util.wait(2);
        System.out.println("ST_10001 works!");
    }




}
