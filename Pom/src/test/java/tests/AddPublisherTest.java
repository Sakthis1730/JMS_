package tests;

import base.BaseTest;
import com.aventstack.extentreports.Status;
import com.microsoft.playwright.Page;
import org.lms.listeners.ExtentReportListener;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import utils.ExcelReader;
import utils.ExcelUtils;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
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
            return ReadExcelData("D:\\uploadtest\\addpublisher.xlsx",4);

        }

        @Test(priority = 1, dataProvider = "getdata",enabled = false)
        public void AddPublisherWithCopyTatData(String acro,String pub) {
            ExtentReportListener.getTest().assignCategory("Add Publisher");
            ExtentReportListener.getTest().log(Status.INFO,"Enter all the input which are mandatory");
            ExtentReportListener.getTest().log(Status.INFO,"verifying publiher is added");

            List<Object[]> excelData = ExcelUtils.getExcelData("D:\\uploadtest\\addpublisher.xlsx",0);


            //Iterate through the data and call the addpublisher method


            for (Object[] row : excelData) {
                if (row.length == 27) { // Ensure the row has the expected number of columns
                    String a = row[0].toString();
                    String b = row[1].toString();
                    String c = row[2].toString();
                    String d = row[3].toString();
                    String e = row[4].toString();
                    String f = row[5].toString();
                    String g = row[6].toString();
                    String h = row[7].toString();
                    String i = row[8].toString();
                    String j = row[9].toString();
                    String k = row[10].toString();
                    String l = row[11].toString();
                    String m = row[12].toString();
                    String n = row[13].toString();
                    String o = row[14].toString();
                    String p = row[15].toString();
                    String q = row[16].toString();
                    String r = row[17].toString();
                    String s = row[18].toString();
                    String t = row[19].toString();
                    String u = row[20].toString();
                    String v = row[21].toString();
                    String w = row[22].toString();
                    String x = row[23].toString();
                    String y = row[24].toString();
                    String z = row[25].toString();
                    String aa = row[26].toString();

                    String Acroname = addpublisherpage.addpublisher(acro, pub, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z, aa);
                    System.out.println("Publisher added: " + Acroname);
                    Assert.assertEquals(Acroname, acro, "Publisher not added successfully");
                } else {
                    System.out.println("Row does not have the expected number of columns: " + row.length);
                }
            }
            ExtentReportListener.getTest().log(Status.INFO,"Publisher added successfully");
        }



    @DataProvider(name = "getalldata")
    public Object[][] getallpublisherdata() throws IOException {
        return ReadExcelData("D:\\uploadtest\\addpublisher.xlsx",1);

    }



    @Test(priority = 2, dataProvider = "getalldata",enabled = false)
    public void AddPublisherWithAllInputData(String a,String b,String c,String d,String e,String f,String g,String h,String i,String j,String k,String l,String m,String n,String o,String p,String q,String r,String s,String t,String u,String v,String w,String x,String y,String z,String aa,String bb,String cc,String dd,String ee,String ff,String gg,String hh,String ii,String jj,String kk,String ll,String mm,String nn,String oo,String pp,String qq,String rr,String ss) {
        ExtentReportListener.getTest().assignCategory("Add Publisher");
        ExtentReportListener.getTest().log(Status.INFO,"Enter all the input which are mandatory");
        ExtentReportListener.getTest().log(Status.INFO,"verifying publiher is added");



      String pubname=addpublisherpage.AddPublisherWithAllData(a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z,aa,bb,cc,dd,ee,ff,gg,hh,ii,jj,kk,ll,mm,nn,oo,pp,qq,rr,ss);
     Assert.assertEquals(pubname,a,"publisher not added successfully");
        ExtentReportListener.getTest().log(Status.INFO,"Publisher added successfully");
    }


    @DataProvider(name = "addpub")
    public Object[][] addpub() throws IOException {
        return  ExcelReader.ReadExcelData ("D:\\uploadtest\\addpublisher.xlsx",0);
    }





    @Test(priority =3,dataProvider = "addpub",enabled = false)
    public void VerifyAcronymCopyTatValue(String a,String b,String c,String d,String e,String f,String g,String h,String i,String j,String k,String l,String m,String n,String o,String p,String q,String r,String s,String t,String u,String v,String w,String x,String y,String z,String aa)
    {
        ExtentReportListener.getTest().assignCategory("Add Publisher");
        ExtentReportListener.getTest().log(Status.INFO,"Enter all the input which are mandatory");
        ExtentReportListener.getTest().log(Status.INFO,"click the copy tat icon");
        ExtentReportListener.getTest().log(Status.INFO,"verifing the Latexduedate for fasttrack which is imported from general");

         addpublisherpage.verify_Tat_values(a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z,aa);

         SoftAssert sassert=new SoftAssert();

        sassert.assertEquals(addpublisherpage.f_latex_val,i,"value not equal");


        sassert.assertEquals(addpublisherpage.f_graph_val,j,"value not equal");
        sassert.assertEquals(addpublisherpage.f_pre_val,k,"value not equal");

        sassert.assertEquals(addpublisherpage.f_copy_edit_val,l,"value not equal");

        sassert.assertEquals(addpublisherpage.f_ts_val,m,"vale not equal");

        sassert.assertEquals(addpublisherpage.f_qc_val,n,"val not equal");


        try {
            sassert.assertAll();
            ExtentReportListener.getTest().log(Status.INFO,"Value  fetched successfully to Fast Track and also verification is wright!");

        } catch (AssertionError err) {
            // Log the assertion errors to the Extent Report
            ExtentReportListener.getTest().log(Status.FAIL, "Assertions failed: " +err.getMessage());
            ExtentReportListener.getTest().log(Status.INFO,"Value not fetched successfully to Fast Track and also verification is wrong!");

            // Optionally, you can rethrow the exception if you want the test to fail
            throw err;
        }
    }





 @DataProvider(name = "getdecdata")
public Object[][] getdecdata() throws IOException {
    return ExcelReader.ReadExcelData("D:\\uploadtest\\addpublisher.xlsx",0);
}


    @Test(priority =9,dataProvider = "addpub",enabled = false)
    public void verifyTatacceptsDecimal(String a,String b,String c,String d,String e,String f,String g,String h,String i,String j,String k,String l,String m,String n,String o,String p,String q,String r,String s,String t,String u,String v,String w,String x,String y,String z,String aa)
    {
       String f_vl=addpublisherpage.verifyaddpub(a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z,aa);
        Assert.assertEquals(f_vl,i,"Decimal value is not accepted ");
        ExtentReportListener.getTest().log(Status.INFO,"Decimal val accepted");

    }




    @DataProvider(name = "geterrordata")
    public Object[][] getallpublisher() throws IOException {
        return ReadExcelData("D:\\uploadtest\\addpublisher.xlsx",2);

    }


    @Test(priority =4,dataProvider = "geterrordata",enabled = false)
    public void VerifyAlertIsShowingWhenAddDuplicateInPubAndAcro(String a,String b)
    {
        ExtentReportListener.getTest().assignCategory("Add Publisher");
        ExtentReportListener.getTest().log(Status.INFO,"verify duplicate alert is showing When add a duplicate pub");

        String error=addpublisherpage.VerifyPublisherNotDuplicate(a,b);
        System.out.println(error);
        Assert.assertEquals(error,"Publisher already exists","alert is not showing");
        ExtentReportListener.getTest().log(Status.INFO,"publisher and Acro name should not duplicate");


    }





    @DataProvider(name = "getfilename")
    public Object[][] getallpublisherlog() throws IOException {
        return ReadExcelData("D:\\uploadtest\\addpublisher.xlsx",3);

    }

    @Test(priority =5,dataProvider = "getfilename",enabled = false)
    public void verifyAddedPublisherLogo(String a,String b,String c)
    {
        ExtentReportListener.getTest().assignCategory("Add Publisher");

        String logoname=addpublisherpage.addpublisherwithlogo(a,b,c);
        System.out.println("File name is"+logoname);
        Assert.assertEquals(logoname,c,"Logofileincorrectorempty in the edit pub");

    }





   @Test(priority =6,enabled = false)
    public void verifyupdatedpublisher()
    {
        ExtentReportListener.getTest().assignCategory("Add Publisher");
        ExtentReportListener.getTest().log(Status.INFO,"Publisher added successfully");
        ExtentReportListener.getTest().log(Status.INFO,"verifing the updated field in Edit publisher");
        LocalDate today = LocalDate.now();
        LocalDate tomarrow=today.plusDays(1);

        String formattedDate = today.format(DateTimeFormatter.ISO_LOCAL_DATE);
        String tomorrow = (today.plusDays(1)).format(DateTimeFormatter.ISO_DATE);

        String changedDate=addpublisherpage.addpublisher("EP");

        Assert.assertEquals(changedDate,tomorrow,"Date not updated in Edit publisher");
        ExtentReportListener.getTest().log(Status.INFO,"Publisher details updated successfully");

    }

    @DataProvider
    public Object[][] verifylogo() throws IOException {
        return ExcelReader.ReadExcelData("D:\\uploadtest\\addpublisher.xlsx",5);
    }


    @Test(priority =7,enabled = false)
    public void verifyupdatedlogo()
    {
        addpublisherpage.addpub("LT");
        String imagename= addpublisherpage.verifylog("LT","Ai.jpg");
       ExtentReportListener.getTest().assignCategory("Add Publisher");
       Assert.assertEquals(imagename,"Ai.jpg","reupload is not success");
       ExtentReportListener.getTest().log(Status.INFO,"Image reuploaded successfully and correctly viewed in the publisher view");

    }



    @Test(priority = 8,dependsOnMethods = "AddPublisherWithCopyTatData",enabled = false)
    public void VerifyPubAvailInAddJournal()
    {
        addpublisherpage.addpub("AT");
        List<String>publist =addpublisherpage.pubavailinjournal("AllTat");
        for(String pubname:publist)
        {
            if(pubname.equals("AllTat"))
            {
                System.out.println(pubname);
                Assert.assertEquals(pubname,"AllTat","pub not displayed");
                break;
            }
        }

    }

    @Test(priority =10,enabled = false)
    public void VerifyFileInRecentUntilMoveTOArchieve()
    {
        ExtentReportListener.getTest().assignCategory("Add Publisher");
        String text=  addpublisherpage.checkrecentfiles();
        ExtentReportListener.getTest().log(Status.INFO,"verifing the uploaded files is showing in Recent files");
        Assert.assertEquals(text,"Latest Files","showing unexpected name:"+text);
        ExtentReportListener.getTest().log(Status.INFO,"uploaded files are showing in the Recent files");


    }


    @DataProvider(name = "getstyfilename")
    public Object[][] getstylefilename() throws IOException {
        return ExcelReader.ReadExcelData("D:\\uploadtest\\addpublisher.xlsx",6);
    }

    @Test(priority = 11,dataProvider = "getstyfilename")
    public void VerifyStypeUploadRestriction(String a)
    {
        addpublisherpage.verifystyformat(a);


    }






















}
