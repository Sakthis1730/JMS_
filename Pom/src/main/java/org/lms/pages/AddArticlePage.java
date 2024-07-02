package org.lms.pages;

import com.microsoft.playwright.FileChooser;
import com.microsoft.playwright.Page;

import java.nio.file.Paths;

public class AddArticlePage {

    private Page page;
    FileChooser fileChooser;

    private  String baseicon="//img[@src='/jms/src/assets/GeneralIcons/shortcuts.svg']";
    private String addarticleicon="id=add_article";
    private String uploadform="//*[@alt='Option 1 (Upload)']";
    private String articleidinput="id=articleID";
    private String selectprioritydropdown="id=priority";
    private String selectpriority="//*[@id='priority']//following::p[text()='High']";
    private String selecttat="//label[text()='TAT']//following::div[1]";
    private String selecttatinput="//label[text()='TAT']//following::li[1]//following::p[1]";
    private String Doino="id=doi";
    private String  selectworkflowdropdown="id=workFlow";
    private String selectworkflow="//*[@id='workFlow']//following::p[text()='Fresh']";
    private String noofpages="//input[@id='numberOfPages']";
    private String cebypass="id=CE by-pass";
    private String form="//img[@alt='Option 2 (Form)']";

    public AddArticlePage(Page page)
    {
        this.page=page;
    }

    public void addarticlebyform()
    {
        page.locator(baseicon).click();
        page.locator(addarticleicon).click();
        page.locator(form).click();

    }



      /*  public void AddArticleWithUpload()
        {

            page.locator(baseicon).click();
            page.locator(addarticleicon).click();
            fileChooser = page.waitForFileChooser(() -> page.locator(uploadform).click());

            fileChooser.setFiles(Paths.get("GGD-805.zip"));
            page.locator(articleidinput).fill("222222222");

            page.locator(selectprioritydropdown).click();
            page.locator(selectpriority).click();

            page.locator(selecttat).click();
            page.locator(selecttatinput).click();

            page.locator(selectworkflowdropdown).click();
            page.locator(selectworkflow).click();

            page.locator(noofpages).fill("200");

            page.locator(Doino).fill("23456789");

            page.locator(cebypass).click();
        }*/






}
