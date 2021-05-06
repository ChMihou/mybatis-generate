package com.java.workstudy.selenium;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Random;

@Controller
public class SeleniumController {

    @RequestMapping("/")
    public String test() {
        return "/TestOffer";
    }

    @RequestMapping("/testSelenium")
    @ResponseBody
    public boolean testSelenium(Offer param) throws Exception {
        String filePath = "D:/offer.xls";
        String path = "D:/work.txt";
        int i = 3;
        List<Offer> offers = ExcelImport.importExcelAction(filePath);
        List<String> uas = readtxt.readTxt(path);
        Random random = new Random();
        while (i > 0) {
            int uaNumber = Math.abs(random.nextInt(uas.size()));
            int offerNumber = Math.abs(random.nextInt(offers.size()));
            System.out.println("虚伪身份访问:" + uas.get(uaNumber));
            Selenium.Selenium(offers.get(offerNumber), uas.get(uaNumber), param);
            i--;
        }
        return true;
    }
}
