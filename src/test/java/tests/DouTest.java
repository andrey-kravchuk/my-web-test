package tests;

import enums.Tabs;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import pages.CompaniesPage;
import pages.MainPage;
import pages.SalariesPage;
import pages.WorkPage;

public class DouTest extends TestBase {




    @Test
    public void javaSeniorSoftwareEngineerCurrentMaxSalary(){
        new MainPage().open()
                .navigateByClickingOnHeaderTab(new SalariesPage(), Tabs.SALARIES)
                .setCity("вся Украина")
                .setJobPosition("Senior Software Engineer")
                .setPeriod("июнь-июль 2019")
                .setProgrammingLanguage("Java")
                .setLeftSlider(90)    //3 years
                .setRightSlider(-190) //3 years
                .shouldSeeSelectedCity("вся Украина")
                .shouldSeeSelectedJob("Senior Software Engineer")
                .shouldSeeSelectedPeriod("июнь-июль 2019")
                .shouldSeeSelectedLanguage("Java")
                .shouldSeeThatSliderIsSetCorrectly("left: 30%; width: 0%;")//3 years
                .shouldSeeMaxSalary("4000")
                .setJobPosition("Junior Software Engineer")
                .setPeriod("июнь-июль 2019")
                .setRightSlider(60) //5 years
                .setLeftSlider(-30) //2 years
                .shouldSeeSelectedCity("вся Украина")
                .shouldSeeSelectedJob("Junior Software Engineer")
                .shouldSeeSelectedPeriod("июнь-июль 2019")
                .shouldSeeSelectedLanguage("Java")
                .shouldSeeThatSliderIsSetCorrectly("left: 20%; width: 30%;") //2-5 years
                .shouldSeeMedianSalary("1300");
    }



    @Test
    public void pmSalaryOnDecember2011() {
        new MainPage().open()
                .navigateByClickingOnHeaderTab(new SalariesPage(), Tabs.SALARIES)
                .setCity("Киев")
                .setJobPosition("Project manager")
                .setPeriod("декабрь 2011")
                .shouldSeeSelectedCity("Киев")
                .shouldSeeSelectedJob("Project manager")
                .shouldSeeSelectedPeriod("декабрь 2011")
                .shouldSeeMaxSalary("3000");
    }

    @Test
    public void cloudBeesCompanyLinkRedirectsToProperWebSite() {
        new MainPage().open()
                .navigateByClickingOnHeaderTab(new WorkPage(), Tabs.WORK)
                .navigateByClickingOnSubheaderTab(new CompaniesPage(), Tabs.COMPANIES)
                .searchCompany("CloudBees")
//                .openCompanyPage("CloudBees")
                .clickOnCompanyWebsiteAndVerifyTitle("CloudBees");

    }

    @BeforeMethod(alwaysRun = true)
    public void before() {
        createDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void after() {
        removeDriver();
    }
}
