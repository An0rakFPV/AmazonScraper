package amazon;

import java.io.IOException;

public class Run {

	public static void main(String[] args) throws IOException {
		String webSource = SocketConnection.getURLSource("https://www.amazon.com/DJI-CP-PT-000500-Mavic-Pro/dp/B01LZ8QTSU/ref=br_asw_pdt-3?pf_rd_m=ATVPDKIKX0DER&pf_rd_s=&pf_rd_r=V6BCHS9X9SAXJTJEWSJS&pf_rd_t=36701&pf_rd_p=2700fa05-7ca0-44e2-bd6a-15ce263293c4&pf_rd_i=desktop");
		String webSource2 = SocketConnection.getURLSource("https://www.amazon.com/Bushs-Best-Homestyle-Baked-Beans/dp/B01MSUUS9H/ref=sr_1_1_sspa?ie=UTF8&qid=1512628708&sr=8-1-spons&keywords=baked%2Bbeans&th=1");
		String webSource3 = SocketConnection.getURLSource("https://www.amazon.com/Sports-Ultimate-Frisbee-Adults-Jebor/dp/B073ZDYTCP/ref=sr_1_1_sspa?s=leisure-sports-games&ie=UTF8&qid=1512669880&sr=1-1-spons&keywords=frisbee&psc=1");
		
		String stockSource = SocketConnection.getURLSource("https://finance.yahoo.com/quote/AAPL?p=AAPL");
		String stockSource2 = SocketConnection.getURLSource("https://finance.yahoo.com/quote/MSFT?p=MSFT");
		
		String dowSource = SocketConnection.getURLSource("http://money.cnn.com/data/dow30/");
		
//		System.out.println(getAmazonPrice(webSource));
//		System.out.println(getAmazonPrice(webSource2));
//		System.out.println(getAmazonPrice(webSource3));
//		System.out.println();
//		System.out.println(getStockPrice(stockSource2));
		
	}
	
	public static String getAmazonPrice(String source)
	{
		source = source.substring(source.indexOf(">Price:"));
		
		return source.substring(source.indexOf("$"), source.indexOf("</span>"));
	}
	
	public static String getStockPrice(String source)
	{
		String beginSearch = "<!-- react-text: 36 -->";
		String endSearch = "<!-- /react-text -->";	//cut down string before using this
		source = source.substring(source.indexOf(beginSearch));
		
		return "$" + source.substring(source.indexOf(beginSearch)+beginSearch.length(), source.indexOf(endSearch));
	}
	
	public static String[] getDow30Tickers(String source)
	{
		String[] tickers = new String[29];
		
		int iterations = 0;
		
		String beginSearch = "class=\"wsod_symbol\">";
		String endSearch = "</a>&nbsp";
		
		while(source.indexOf(beginSearch) != -1)
		{
			tickers[iterations] = source.substring(source.indexOf(beginSearch) + beginSearch.length(), source.indexOf(endSearch));
			
			source = source.substring(source.indexOf(endSearch) + 1);
			
			iterations++;
		}
		
		return tickers;
	}

}
