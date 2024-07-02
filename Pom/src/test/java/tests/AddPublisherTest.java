package tests;

import base.BaseTest;
import com.aventstack.extentreports.Status;
import com.microsoft.playwright.Page;
import org.lms.listeners.ExtentReportListener;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;

import static utils.ExcelReader.ReadExcelData;
@Listeners(ExtentReportListener.class)
public class AddPublisherTest extends BaseTest {

    @BeforeMethod
    public void beforeallTest()
    {
        addpublisherpage=homepage.navigatetoaddpublisherpage();
        addpublisherpage.verifyAddPublisherIconIsClickable();

    }

    @Test(priority = 0)
    public void NavigateToAddPubIcon()
    {
        ExtentReportListener.getTest().assignCategory("Add Publisher");
        ExtentReportListener.getTest().log(Status.INFO,"Clicking the Base icon");
        ExtentReportListener.getTest().log(Status.INFO,"Clicking the add publisher icon");



        addpublisherpage.verifyAddPublisherIconIsClickable();
        ExtentReportListener.getTest().log(Status.INFO,"Navigated successfully to the addpublisher page");

    }

    @DataProvider(name = "getdata")
    public Object[][] getpublisherdata() throws IOException {
        return ReadExcelData("D:\\uploadtest\\addpublisher.xlsx",0);

    }

    @Test(priority = 1, dataProvider = "getdata")
    public void AddPublisherWithCopyTatData(String a,String b,String c,String d,String e,String f,String g,String h,String i,String j,String k,String l,String m,String n,String o,String p,String q,String r,String s,String t,String u,String v,String w,String x,String y,String z,String aa) {
       ExtentReportListener.getTest().assignCategory("Add Publisher");
        ExtentReportListener.getTest().log(Status.INFO,"Enter all the input which are mandatory");
        ExtentReportListener.getTest().log(Status.INFO,"verifying publiher is added");
        String Acroname=addpublisherpage.addpublisher(a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z,aa);
        System.out.println("publisher added"+Acroname);
        Assert.assertEquals(Acroname,a,"publisher not added successfully");
        ExtentReportListener.getTest().log(Status.INFO,"Publisher added successfully");
    }

    @DataProvider(name = "getalldata")
    public Object[][] getallpublisherdata() throws IOException {
        return ReadExcelData("D:\\uploadtest\\addpublisher.xlsx",1);

    }



    @Test(priority = 2, dataProvider = "getalldata")
    public void AddPublisherWithAllInputData(String a,String b,String c,String d,String e,String f,String g,String h,String i,String j,String k,String l,String m,String n,String o,String p,String q,String r,String s,String t,String u,String v,String w,String x,String y,String z,String aa,String bb,String cc,String dd,String ee,String ff,String gg,String hh,String ii,String jj,String kk,String ll,String mm,String nn,String oo,String pp,String qq,String rr,String ss) {
        ExtentReportListener.getTest().assignCategory("Add Publisher");
        ExtentReportListener.getTest().log(Status.INFO,"Enter all the input which are mandatory");
        ExtentReportListener.getTest().log(Status.INFO,"verifying publiher is added");



      String pubname=addpublisherpage.AddPublisherWithAllData(a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z,aa,bb,cc,dd,ee,ff,gg,hh,ii,jj,kk,ll,mm,nn,oo,pp,qq,rr,ss);
     Assert.assertEquals(pubname,a,"publisher not added successfully");
        ExtentReportListener.getTest().log(Status.INFO,"Publisher added successfully");
    }

    @Test(priority =3,dataProvider = "getdata")
    public void VerifyAcronymCopyTatValue(String a,String b,String c,String d,String e,String f,String g,String h,String i,String j,String k,String l,String m,String n,String o,String p,String q,String r,String s,String t,String u,String v,String w,String x,String y,String z,String aa)
    {
        ExtentReportListener.getTest().assignCategory("Add Publisher");
        ExtentReportListener.getTest().log(Status.INFO,"Enter all the input which are mandatory");
        ExtentReportListener.getTest().log(Status.INFO,"click the copy tat icon");
        ExtentReportListener.getTest().log(Status.INFO,"verifing the Latexduedate for fasttrack which is imported from general");

        String latex_due_date= addpublisherpage.verify_Tat_values(a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z,aa);
        System.out.println(latex_due_date);
        Assert.assertEquals(latex_due_date,"1","value not equal");
        ExtentReportListener.getTest().log(Status.INFO,"Value fetched successfully to Fast Track and also verification is right!");

    }







}
