package org.example;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {

    /**
     * @param url the url of the website we are scrpaing
     * @return the HtmlPage object of the url
     */
    public static HtmlPage getDocument(String url) {
        HtmlPage page = null;
        try (final WebClient webClient = new WebClient()) {
            webClient.getOptions().setCssEnabled(false);
            webClient.getOptions().setJavaScriptEnabled(false);
            page = webClient.getPage(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return page;
    }

    /**
     * @param URL the url of the website we are scrpaing
     * @return  the price of the product in the URL
     */
    public static String getPriceFromURL(String URL){
        WebClient webClient = new WebClient();
        webClient.getOptions().setCssEnabled(false);
        webClient.getOptions().setJavaScriptEnabled(false);



        HtmlPage page = getDocument(URL);
        HtmlElement priceHtml = page.getFirstByXPath("//div[@class='sc-dd9e2587-7 bwPUUQ']/span[last()]");
        String name = priceHtml.asNormalizedText();
        return name;
    }

    /**
     * @param URL the url of the website we are scrpaing
     * @return  the amount of the product in the URL
     */

    public static String getAmountFromURL(String URL){

        WebClient webClient = new WebClient();
        webClient.getOptions().setCssEnabled(false);
        webClient.getOptions().setJavaScriptEnabled(false);



        HtmlPage page = getDocument(URL);
        HtmlElement amountHtml = page.getFirstByXPath("//div[@class='sc-dd9e2587-2 fmWgoH']/span");
        String name = amountHtml.asNormalizedText();
        return name;
    }

    /**
     * @param URL the url of the website we are scrpaing
     * @return  the price of the product in the URL
     */
    public static String getNameFromURL(String URL){
        WebClient webClient = new WebClient();
        webClient.getOptions().setCssEnabled(false);
        webClient.getOptions().setJavaScriptEnabled(false);



        HtmlPage page = getDocument(URL);
        HtmlElement nameHtml = page.getFirstByXPath("//h2[@class ='style__Title2-sc-__sc-1nwjacj-3 iPNYeh sc-dd9e2587-4 fcZXLp']");
        String price = nameHtml.asNormalizedText();
        return price;
    }

    /**
     * @param fileNameWithUrl the file name,
     * @param urls,names,prices,amounts the ArrayLists
     * @return  filled ArrayLists
     */
    
     public static void fillArrays(String fileNameWithURL, ArrayList<String> urls, ArrayList<String> names, ArrayList<String> prices, ArrayList<String> amounts) throws FileNotFoundException{

        fileNameWithURL += ".txt";
        File file = new File(fileNameWithURL);
        
        Scanner sc = new Scanner(file);
        String url;

        while (sc.hasNext()){
            url = sc.nextLine();
            url = url.trim();
            urls.add(url);
            names.add(getNameFromURL(url));
            prices.add(getPriceFromURL(url));
            amounts.add(getAmountFromURL(url));   
        }

        System.out.println(names.toString());
        System.out.println(prices.toString());
        System.out.println(amounts.toString());
    }
    

        public static void main(String[] args) throws IOException {

            ArrayList<String> urls = new ArrayList<>();
            ArrayList<String> names = new ArrayList<>();
            ArrayList<String> prices = new ArrayList<>();
            ArrayList<String> amounts = new ArrayList<>();

       fillArrays("urls", urls, names, prices, amounts);

    
       



    }
}