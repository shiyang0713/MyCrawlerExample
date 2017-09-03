package crawler.example;

import com.github.abola.crawler.CrawlerPack;
import org.apache.commons.logging.impl.SimpleLog;
import org.jsoup.select.Elements;

/**
 * 爬蟲包程式的全貌，就只有這固定的模式
 * 
 * @author Abola Lee
 *
 */
public class BasicExample {
	// commit test test
	public static void main(String[] args) {

		// set to debug level
		//CrawlerPack.setLoggerLevel(SimpleLog.LOG_LEVEL_DEBUG);

		// turn off logging
		CrawlerPack.setLoggerLevel(SimpleLog.LOG_LEVEL_OFF);

		// 遠端資料路徑
		String uri = "https://www.ptt.cc/bbs/Gossiping/M.1504404040.A.387.html";
		//移除所有div顯示文章內容
		Elements elem =CrawlerPack.start().addCookie("over18","1").getFromHtml(uri)
						   .select("#main-content");
				elem.select("div").remove();//remove() -> void



		System.out.println(elem.text()  //text() 取得tag中的文字內容
				//CrawlerPack.start()
				// 參數設定
			    //.addCookie("over18","1")	// 設定cookie
				//.setRemoteEncoding("big5")// 設定遠端資料文件編碼
				
				// 選擇資料格式 (三選一)
				//.getFromJson(uri)
			    //.getFromHtml(uri)
			    //.getFromXml(uri)
			    
			    // 這兒開始是 Jsoup Document 物件操作

			    //.select("div.push:contains(推)") //顯示只有推的資料
				//.select("div.push:contains(推)>.f3.hl.push-userid") //顯示推文id
				//.select("div.push:contains(推)>.f3.push-content") //顯示推文內容



		);
	}
}
