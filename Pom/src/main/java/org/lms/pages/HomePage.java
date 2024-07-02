package org.lms.pages;

import com.microsoft.playwright.Page;
import static  com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class HomePage {

    private Page page;
    private String lmslogo = "//img[@alt='LMS logo']";
    private String knowledgebank = "//p[text()='Knowledge Bank']";
    private String trainer = "//img[@alt='Trainer']";
    private String Add_course = "//img[@alt='Add Course']";
    private String baseicon = "//img[@src='/jms/src/assets/GeneralIcons/shortcuts.svg']";
    private String addpubicon="id=add_publisher";



    public HomePage(Page page) {
        this.page = page;
    }

    public String verifyurl() {
        return page.url();
    }

    public String verifytitle() {
        return page.title();
    }


    public boolean  isbaseicondisplayed() {

        assertThat(page.locator(baseicon)).isAttached();
       return page.locator(baseicon).isVisible();


    }


    public AddPublisherPage navigatetoaddpublisherpage() {

        page.url();

        return new AddPublisherPage(page);
    }




   /* public AddArticlePage navigatetoaddarticlepage() {

        page.url();

        return new AddArticlePage(page);
    }
*/
}
