package amazon;

import java.io.IOException;

public class Run {

	public static void main(String[] args) throws IOException {
		String webSource = SocketConnection.getURLSource("https://www.amazon.com/DJI-CP-PT-000500-Mavic-Pro/dp/B01LZ8QTSU/ref=br_asw_pdt-3?pf_rd_m=ATVPDKIKX0DER&pf_rd_s=&pf_rd_r=V6BCHS9X9SAXJTJEWSJS&pf_rd_t=36701&pf_rd_p=2700fa05-7ca0-44e2-bd6a-15ce263293c4&pf_rd_i=desktop");
		String webSource2 = SocketConnection.getURLSource("https://www.amazon.com/Bushs-Best-Homestyle-Baked-Beans/dp/B01MSUUS9H/ref=sr_1_1_sspa?ie=UTF8&qid=1512628708&sr=8-1-spons&keywords=baked%2Bbeans&th=1");
		
		System.out.println(getPrice(webSource2));
	}
	
	public static String getPrice(String source)
	{
		source = source.substring(source.indexOf("Price:"));
		
		return source.substring(source.indexOf("$"), source.indexOf("</span>"));
	}

}
