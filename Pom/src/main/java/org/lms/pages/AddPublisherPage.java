package org.lms.pages;

import com.aventstack.extentreports.util.Assert;
import com.microsoft.playwright.FileChooser;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import java.nio.file.Paths;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class AddPublisherPage {

    private Page page;
    FileChooser fileChooser;


    private  String baseicon="//img[@src='/jms/src/assets/GeneralIcons/shortcuts.svg']";
    private String addpubicon="id=add_publisher";


    private String pub_acronym="//input[@data-testid='publisher-acronym']";
    private String pub_name_textbox="//input[@data-testid='publisher-name']";
    private String pub_mail_textbox="//input[@data-testid='email-account']";
    private String desc_inputbox="//*[@name='description']";
    private String selectdateinput="//input[@type='date']";
    private String pub_location="//input[@data-testid='publisher-location']";
    private String ftpusername="//input[@data-testid='ftp-user-name']";
    private String ftppassword="//input[@data-testid='ftp-password']";
    private String ftp_initial_directory="//input[@data-testid='ftp-initial-directory']";
    private String daysforlatexnormalization="//h2[text()='General']//following::input[@data-testid='days-for-latex-normalization'][1]";
    private String daysforgraphics="(//h3[text()='TAT for First Proof']//following::input[@data-testid='number-of-days-for-graphics'])[1]";
    private String daysforPreediting="(//h3[text()='TAT for First Proof']//following::input[@data-testid='number-of-days-for-pre-editing'])[1]";
    private String daysforcopyediting="(//h3[text()='TAT for First Proof']//following::input[@data-testid='number-of-days-for-copyediting'])[1]";
    private String daysfortypesettings="(//h3[text()='TAT for First Proof']//following::input[@data-testid='number-of-days-for-typesetting'])[1]";
    private String daysforqc="(//h3[text()='TAT for First Proof']//following::input[@data-testid='number-of-days-for-qc'])[1]";
   private String daysforaupag="(//h2[text()='General']//following::h3[text()='TAT for AU Revises ']//following::input[@data-testid='number-of-days-for-pagination'])[1]";
   private String daysforauqc="(//h2[text()='General']//following::h3[text()='TAT for AU Revises ']//following::input[@data-testid='number-of-days-for-qc'])[1]";
    private String daysforpepag="(//h2[text()='General']//following::h3[text()=' TAT for PE Revises ']//following::input[@data-testid='number-of-days-for-pagination'])[1]";
    private String daysforpeqc="(//h2[text()='General']//following::h3[text()=' TAT for PE Revises ']//following::input[@data-testid='number-of-days-for-qc'])[1]";
    private String daysforonlinepag="(//h2[text()='General']//following::h3[text()=' TAT for Online First ']//following::input[@data-testid='hours-or-days-for-Pagination'])[1]";
    private String daysforonlineqc="(//h2[text()='General']//following::h3[text()=' TAT for Online First ']//following::input[@data-testid='hours-or-days-for-QC'])[1]";
    private String daysforonlinexml="(//h2[text()='General']//following::h3[text()=' TAT for Online First ']//following::input[@data-testid='hours-days-for-xml'])[1]";
    private String IssuePag="(//h2[text()='General']//following::h3[text()=' TAT for Issue']//following::input[@data-testid='number-of-days-for-pagination'])[1]";
    private String IssueQC="(//h2[text()='General']//following::h3[text()=' TAT for Issue']//following::input[@data-testid='number-of-days-for-qc'])[1]";
    private String printpag="(//h2[text()='General']//following::h3[text()=' TAT for Print/Web ']//following::input[@data-testid='number-of-days-for-pagination'])[1]";
    private String printQC="(//h2[text()='General']//following::h3[text()=' TAT for Print/Web ']//following::input[@data-testid='number-of-days-for-qc'])[1]";
    private String printxml="(//h2[text()='General']//following::h3[text()=' TAT for Print/Web ']//following::input[@data-testid='number-of-days-for-xml'])[1]";
   private String addbutton="//*[@data-testid='submit-button']";

    private String Imageuploadbutton="//button[text()='Upload Image']";

    private String styletemplate="//*[@id='styles-upload']//preceding::div[1]";

    private String guidelinesdoc="//*[@id='guidelines-upload']//preceding::div[1]";
    private String CopyTat="//*[@title='Replicate values from General to Fasttrack']";
    private String CopyTatConfirm="//*[text()='Yes']";
    private String managemenu="//div[@id='root']//following::p[text()='Manage']";

    //webelement for fasttrack

    private String f_LatexNormal="//h2[text()='Fasttrack']//following::h3[text()='TAT for First Proof']//following::input[@data-testid='days-for-latex-normalization']";
    private String f_graphics="//h2[text()='Fasttrack']//following::h3[text()='TAT for First Proof']//following::input[@data-testid='number-of-days-for-graphics']";
    private String f_preedit="//h2[text()='Fasttrack']//following::h3[text()='TAT for First Proof']//following::input[@data-testid='number-of-days-for-pre-editing']";
    private String f_copyedit="//h2[text()='Fasttrack']//following::h3[text()='TAT for First Proof']//following::input[@data-testid='number-of-days-for-copyediting']";

    private String f_ts="//h2[text()='Fasttrack']//following::h3[text()='TAT for First Proof']//following::input[@data-testid='number-of-days-for-typesetting']";
    private String f_qc="(//h2[text()='Fasttrack']//following::h3[text()='TAT for First Proof']//following::input[@data-testid='number-of-days-for-qc'][1])";
    private  String f_au_pag="//h2[text()='Fasttrack']//following::h3[text()='TAT for AU Revises ']//following::input[@data-testid='number-of-days-for-pagination'][1]";
    private String f_au_qc="//h2[text()='Fasttrack']//following::h3[text()='TAT for AU Revises ']//following::input[@data-testid='number-of-days-for-qc'][1]";
    private String f_pe_pag="//h2[text()='Fasttrack']//following::h3[text()=' TAT for PE Revises ']//following::input[@data-testid='number-of-days-for-pagination'][1]";
    private String f_pe_qc="//h2[text()='Fasttrack']//following::h3[text()=' TAT for PE Revises ']//following::input[@data-testid='number-of-days-for-qc'][1]";
    private String f_o_pag="//h2[text()='Fasttrack']//following::h3[text()=' TAT for Online First ']//following::input[@data-testid='hours-or-days-for-Pagination']";
    private String f_o_qc="//h2[text()='Fasttrack']//following::h3[text()=' TAT for Online First ']//following::input[@data-testid='hours-or-days-for-QC']";
    private String f_o_xml="//h2[text()='Fasttrack']//following::h3[text()=' TAT for Online First ']//following::input[@data-testid='hours-days-for-xml']";
    private String f_iss_pag="//h2[text()='Fasttrack']//following::h3[text()=' TAT for Issue']//following::input[@data-testid='number-of-days-for-pagination'][1]";
    private String f_iss_qc="//h2[text()='Fasttrack']//following::h3[text()=' TAT for Issue']//following::input[@data-testid='number-of-days-for-qc'][1]";
    private String f_priweb_pag="//h2[text()='Fasttrack']//following::h3[text()=' TAT for Print/Web ']//following::input[@data-testid='number-of-days-for-pagination'][1]";
    private String f_printweb_qc="//h2[text()='Fasttrack']//following::h3[text()=' TAT for Print/Web ']//following::input[@data-testid='number-of-days-for-qc']";
    private String f_printweb_xml="//h2[text()='Fasttrack']//following::h3[text()=' TAT for Print/Web ']//following::input[@data-testid='number-of-days-for-xml']";
    private String addjournalicon="id=add_article";


    public AddPublisherPage(Page page)
    {
        this.page=page;
    }

    public void verifyAddPublisherIconIsClickable()
    {
        page.locator(baseicon).click();
        page.locator(addpubicon).click();

    }

    public String addpublisher(String a,String b,String c,String d,String e,String f,String g,String h,String i,String j,String k,String l,String m,String n,String o,String p,String q,String r,String s,String t,String u,String v,String w,String x,String y,String z,String aa)  {





         page.locator(pub_acronym).fill(a);
         page.locator(pub_name_textbox).fill(b);
         page.locator(pub_mail_textbox).fill(c);
         page.locator(desc_inputbox).fill(d);
        LocalDate currentDate = LocalDate.now();
        String formattedDate = currentDate.format(DateTimeFormatter.ISO_LOCAL_DATE);
        page.locator(selectdateinput).fill(formattedDate);
        page.locator(selectdateinput).fill(formattedDate);
         page.locator(pub_location).fill(e);
         page.locator(ftpusername).fill(f);
         page.locator(ftppassword).fill(g);


         page.locator(ftp_initial_directory).fill(h);
         page.locator(daysforlatexnormalization).fill(i);
         page.locator(daysforgraphics).fill(j);
         page.locator(daysforPreediting).fill(k);
         page.locator(daysforcopyediting).fill(l);
         page.locator(daysforlatexnormalization).fill(m);
         page.locator(daysfortypesettings).fill(n);
         page.locator(daysforqc).fill(o);
         page.locator(daysforaupag).fill(p);
        page.locator(daysforauqc).fill(q);
        page.locator(daysforpepag).fill(r);
        page.locator(daysforpeqc).fill(s);
        page.locator(daysforonlinepag).fill(t);
        page.locator(daysforonlineqc).fill(u);
        page.locator(daysforonlinexml).fill(v);
        page.locator(IssuePag).fill(w);
        page.locator(IssueQC).fill(x);
        page.locator(printpag).fill(y);
        page.locator(printQC).fill(z);
        //assertThat(page.locator(printxml)).isAttached();
        page.locator(printxml).fill(aa);


        fileChooser = page.waitForFileChooser(() -> page.locator(Imageuploadbutton).click());
        fileChooser.setFiles(Paths.get("Automation.jpg"));



        fileChooser = page.waitForFileChooser(() -> page.locator(guidelinesdoc).click());
        fileChooser.setFiles(Paths.get("guidelines.docx"));

        page.locator(CopyTat).click();
        page.locator(CopyTatConfirm).click();

        page.locator(addbutton).click();
        page.locator(managemenu).click();
       String val= page.locator("//th[text()='"+a+"']").textContent();
       return  val;




    }

    public String AddPublisherWithAllData(String a,String b,String c,String d,String e,String f,String g,String h,String i,String j,String k,String l,String m,String n,String o,String p,String q,String r,String s,String t,String u,String v,String w,String x,String y,String z,String aa,String bb,String cc,String dd,String ee,String ff,String gg,String hh,String ii,String jj,String kk,String ll,String mm,String nn,String oo,String pp,String qq,String rr,String ss)
    {
        page.locator(pub_acronym).fill(a);
        page.locator(pub_name_textbox).fill(b);
        page.locator(pub_mail_textbox).fill(c);
        page.locator(desc_inputbox).fill(d);
        LocalDate currentDate = LocalDate.now();
        String formattedDate = currentDate.format(DateTimeFormatter.ISO_LOCAL_DATE);
        page.locator(selectdateinput).fill(formattedDate);
        page.locator(selectdateinput).fill(formattedDate);
        page.locator(pub_location).fill(e);
        page.locator(ftpusername).fill(f);
        page.locator(ftppassword).fill(g);


        page.locator(ftp_initial_directory).fill(h);
        page.locator(daysforlatexnormalization).fill(i);
        page.locator(daysforgraphics).fill(j);
        page.locator(daysforPreediting).fill(k);
        page.locator(daysforcopyediting).fill(l);
        page.locator(daysforlatexnormalization).fill(m);
        page.locator(daysfortypesettings).fill(n);
        page.locator(daysforqc).fill(o);
        page.locator(daysforaupag).fill(p);
        page.locator(daysforauqc).fill(q);
        page.locator(daysforpepag).fill(r);
        page.locator(daysforpeqc).fill(s);
        page.locator(daysforonlinepag).fill(t);
        page.locator(daysforonlineqc).fill(u);
        page.locator(daysforonlinexml).fill(v);
        page.locator(IssuePag).fill(w);
        page.locator(IssueQC).fill(x);
        page.locator(printpag).fill(y);
        page.locator(printQC).fill(z);
        page.locator(printxml).fill(aa);
        page.locator(f_LatexNormal).fill(bb);
        page.locator(f_graphics).fill(cc);
        page.locator(f_preedit).fill(dd);
        page.locator(f_copyedit).fill(ee);
        page.locator(f_ts).fill(ff);
        page.locator(f_qc).fill(gg);
        page.locator(f_au_pag).fill(hh);
        page.locator(f_au_qc).fill(ii);
        page.locator(f_pe_pag).fill(jj);
        page.locator(f_pe_qc).fill(kk);
        page.locator(f_o_pag).fill(ll);
        page.locator(f_o_qc).fill(mm);
        page.locator(f_o_xml).fill(nn);
        page.locator(IssuePag).fill(oo);
        page.locator(IssueQC).fill(pp);
        page.locator(f_priweb_pag).fill(qq);
        page.locator(f_printweb_qc).fill(rr);
        page.locator(f_printweb_xml).fill(ss);





        fileChooser = page.waitForFileChooser(() -> page.locator(Imageuploadbutton).click());
        fileChooser.setFiles(Paths.get("Automation.jpg"));



        fileChooser = page.waitForFileChooser(() -> page.locator(guidelinesdoc).click());
        fileChooser.setFiles(Paths.get("guidelines.docx"));
        page.locator(addbutton).click();
        page.locator(managemenu).click();
        String val= page.locator("//th[text()='"+a+"']").textContent();
        return  val;


    }

  /*  public String getacrronym()
    {
        page.locator(pub_acronym).fill("1");
        return page.locator(pub_acronym).textContent();

    }

    public void copytat()
    {
        page.locator(CopyTat).click();
        page.locator(CopyTatConfirm).click();
    }*/

    public String verify_Tat_values(String a,String b,String c,String d,String e,String f,String g,String h,String i,String j,String k,String l,String m,String n,String o,String p,String q,String r,String s,String t,String u,String v,String w,String x,String y,String z,String aa)
    {
        page.locator(pub_acronym).fill(a);
        page.locator(pub_name_textbox).fill(b);
        page.locator(pub_mail_textbox).fill(c);
        page.locator(desc_inputbox).fill(d);
        LocalDate currentDate = LocalDate.now();
        String formattedDate = currentDate.format(DateTimeFormatter.ISO_LOCAL_DATE);
        page.locator(selectdateinput).fill(formattedDate);
        page.locator(selectdateinput).fill(formattedDate);
        page.locator(pub_location).fill(e);
        page.locator(ftpusername).fill(f);
        page.locator(ftppassword).fill(g);


        page.locator(ftp_initial_directory).fill(h);
        page.locator(daysforlatexnormalization).fill(i);
        page.locator(daysforgraphics).fill(j);
        page.locator(daysforPreediting).fill(k);
        page.locator(daysforcopyediting).fill(l);
        page.locator(daysforlatexnormalization).fill(m);
        page.locator(daysfortypesettings).fill(n);
        page.locator(daysforqc).fill(o);
        page.locator(daysforaupag).fill(p);
        page.locator(daysforauqc).fill(q);
        page.locator(daysforpepag).fill(r);
        page.locator(daysforpeqc).fill(s);
        page.locator(daysforonlinepag).fill(t);
        page.locator(daysforonlineqc).fill(u);
        page.locator(daysforonlinexml).fill(v);
        page.locator(IssuePag).fill(w);
        page.locator(IssueQC).fill(x);
        page.locator(printpag).fill(y);
        page.locator(printQC).fill(z);
        //assertThat(page.locator(printxml)).isAttached();
        page.locator(printxml).fill(aa);
        page.locator(CopyTat).click();
        page.locator(CopyTatConfirm).click();
        assertThat(page.locator(daysforlatexnormalization)).isEditable();
        return page.locator(daysforlatexnormalization).inputValue();

    }

    public void VerifyPublisherNotDuplicate()
    {
        
    }





}
