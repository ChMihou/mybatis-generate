package com.java.workstudy.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.InetAddress;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Selenium {

    public static void Selenium(Offer offer, String ua, Offer param) throws InterruptedException {
        Thread.sleep(3000);
        //获取Ip
        System.out.println(getIp());
        DesiredCapabilities capabilities;
        ChromeOptions options = new ChromeOptions();
        WebDriver webDriver;
        if (ua.contains("mobile")) {
            Map<String, String> mobileEmulation = new HashMap<String, String>();
            mobileEmulation.put("deviceName", "Galaxy S5");
            ChromeOptions headlessOptions = new ChromeOptions();
            headlessOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
            capabilities = DesiredCapabilities.chrome();
            capabilities.setCapability(ChromeOptions.CAPABILITY, headlessOptions);
            webDriver = new ChromeDriver(capabilities);
        } else {
            options.addArguments("Accept=text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
            options.addArguments("Accept-Encoding=gzip, deflate, sdch");
            options.addArguments("Accept-Language=fr-be,zh;q=0.8");
            options.addArguments("Upgrade-Insecure-Requests=1");
            options.addArguments("User-Agent=" + ua);
            webDriver = new ChromeDriver(options);
        }
        System.setProperty("webdriver.chrome.driver", "d://chromedriver.exe");
        //火狐浏览器
//        System.setProperty("webdriver.gecko.driver", "c://geckodriver.exe");
//        WebDriver webDriver = new FirefoxDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().deleteAllCookies();
        // 与浏览器同步非常重要，必须等待浏览器加载完毕
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //打开目标地址
        webDriver.get(param.getUrl());
        //输入账号 密码并登陆系统
        Thread.sleep(1000);
        webDriver.findElement(new By.ByName("Username")).sendKeys(offer.getLastName());
        webDriver.findElement(new By.ByName("Upassword")).sendKeys(offer.getEmail());
        webDriver.findElement(new By.ByName("checks")).sendKeys(offer.getName());
        webDriver.findElement(new By.ById("login")).click();

        //选择系统
        Thread.sleep(1000);
        webDriver.findElement(By.xpath("/html/body/div/div/div/div[1]/p")).click();

        //展开基础信息管理菜单
        Thread.sleep(1000);
        webDriver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[3]/ul/div[1]/li/div/span")).click();
        //点击科室管理菜单
        Thread.sleep(1000);
        webDriver.findElement(By.cssSelector(".is-opened > ul:nth-child(2) > li:nth-child(1)")).click();

        //跳转到第2页
        Thread.sleep(1000);
        webDriver.findElement(By.xpath("/html/body/div/div/div/div[2]/div[2]/div/div[2]/div[2]/div/div[2]/ul/li[2]")).click();

        //点击新增按钮
        webDriver.findElement(By.xpath("/html/body/div/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div[1]/div[1]/button")).click();

        //根据规则随机生成文本框内容
        int random = new Random().nextInt(200000000);
        Thread.sleep(1000);
        webDriver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div/div[3]/div/div[2]/form/div[1]/div[1]/div/div/input")).sendKeys(String.valueOf(random));
        Thread.sleep(1000);
        webDriver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div/div[3]/div/div[2]/form/div[1]/div[2]/div/div[1]/input")).sendKeys("自动化测试-" + random);

        //展开下拉框
        webDriver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div/div[3]/div/div[2]/form/div[2]/div[1]/div/div/div[1]/span/span/i")).click();
        Thread.sleep(1000);
        //获取下拉框size
        List<WebElement> select1 = webDriver.findElements(By.cssSelector("div.el-select-dropdown:nth-child(4) > div:nth-child(1) > div:nth-child(1) > ul li"));
        //随机选择一个项目
        int selectItem1 = new Random().nextInt(select1.size()) + 1;
        webDriver.findElement(By.xpath("/html/body/div[3]/div[1]/div[1]/ul/li[" + selectItem1 + "]")).click();

        //稍作停顿，然后保存
        Thread.sleep(1000);
        webDriver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div/div[3]/div/div[3]/div/button[1]")).click();

        webDriver.findElements(By.className("postTitle")).forEach(x -> {
            System.out.println(x.getText());
        });

        Thread.sleep(1000);
        //打开标题为 通过Dockerfile构建镜像并发布web项目 的文章
        webDriver.findElement(By.partialLinkText("通过Dockerfile构建镜像并发布web项目")).click();

        Thread.sleep(1000);
        //移动到底部
        //((JavascriptExecutor) webDriver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        //移动到指定的坐标(相对当前的坐标移动)
        ((JavascriptExecutor) webDriver).executeScript("window.scrollBy(0, 700)");
        Thread.sleep(1000);
        //移动到窗口绝对位置坐标，如下移动到纵坐标1600像素位置
        ((JavascriptExecutor) webDriver).executeScript("window.scrollTo(0, 1600)");
        Thread.sleep(1000);
        //移动到指定元素，且元素底部和窗口底部对齐 参考 https://www.cnblogs.com/testway/p/6693140.html
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(false);", webDriver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/div/div[1]/div/div/div[2]/div[4]/div[3]/div[1]/a[5]/img")));
        //暂停五秒钟后关闭
        Thread.sleep(2000);
        webDriver.quit();
    }

    public static String getIp() {
        try {
            InetAddress ia = InetAddress.getLocalHost();
//            String localname = ia.getHostName();
            String localip = ia.getHostAddress();
            return localip;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return "500";
        }
    }
}