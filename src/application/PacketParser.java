package application;

import java.io.IOException;
import java.util.List;

import org.jdom2.Attribute;
import org.jdom2.Content;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.util.IteratorIterable;

public class PacketParser {

	final static String version = "27.7.5";

	public static void main(String args[]) {
		SAXBuilder builder = new SAXBuilder();
		try {
			Document packets = builder.build("src/xml/packets.xml");
			List packetElements = packets.getRootElement().getChildren("Packet");

			System.out.println("[Realm Relay][K-Relay][Java Source] Packets IDs for " + version);
			System.out.println(
					"This thread was generated by Gratin's Java Packet Parser. It takes an input file from JNoob's Packet Parser (credits to @JustANoobROTMG), and formats it into this thread. This code may or may not have been tested, if you get any errors, leave a comment containing the steps to reproduce and the error message. I will do my best to fix it swiftly.");
			System.out.println("");
			System.out.println("If you appreciate my work, any donations would be extremely appreciated.");
			System.out.println("Bitcoin: 18st8gMvHUMTpQvBbrX5koL7nF2Cc1FhtC");
			System.out.println(
					"Paypal: [email]gratinmpb@gmail.com[/email] OR direct link : [url]https://www.paypal.com/cgi-bin/webscr?cmd=_donations&business=5KRKE6B5GS29Y&lc=US&item_name=Realm%2dRelay%20Maintenance&currency_code=USD&bn=PP%2dDonationsBF%3abtn_donateCC_LG%2egif%3aNonHosted[/url]");
			System.out.println("");
			System.out.println("[center][bold][size=5]Realm Relay[/size][/bold][/center]");
			System.out.println("");
			System.out.println(
					"Instructions: Open up the xml folder in your Realm Relay directory, then open packets.xml with a text editor and replace all of the text with the code below.");
			System.out.println("[code]");
			System.out.println("<Packets>");
			for (int i = 0; i <= 92; i++) {
				Element songElement = (Element) packetElements.get(i);
				String name = songElement.getAttributeValue("id");
				String id = songElement.getAttributeValue("type");
				System.out.println("	<Packet id=\"" + name + "\"" + " type=\"" + id + "\"/>");
			}
			System.out.println("</Packets>");
			System.out.println("[/code]");
			System.out.println("[center][bold][size=5]K-Relay[/size][/bold][/center]");
			System.out.println("");
			System.out.println(
					"Instructions: Open up the xml folder in your K-Relay directory, then open packets.xml with a text editor and replace all of the text with the code below.");
			System.out.println("[code]");
			System.out.println("<Packets>");
			for (int i = 0; i <= 92; i++) {
				Element songElement = (Element) packetElements.get(i);
				String name = songElement.getAttributeValue("id");
				String id = songElement.getAttributeValue("type");
				switch (name.toUpperCase()) {
				case ("CREATE_SUCCESS"):
					name = "CREATESUCCESS";
					break;
				case ("NEW_TICK"):
					name = "NEWTICK";
					break;
				case ("SHOW_EFFECT"):
					name = "SHOWEFFECT";
					break;
				case ("GLOBAL_NOTIFICATION"):
					name = "GLOBALNOTIFICATION";
					break;
				case ("ENTER_ARENA"):
					name = "ENTERARENA";
				}
				System.out.println("	<Packet>");
				System.out.println("		<PacketName>" + name + "</PacketName>");
				System.out.println("		<PacketID>" + id + "</PacketID>");
				System.out.println("	</Packet>");
			}
			System.out.println("</Packets>");
			System.out.println("[/code]");
			System.out.println("[center][bold][size=5]Java Source[/size][/bold][/center]");
			System.out.println("");
			System.out.println("Instructions: If you need this, then you already know how to use it.");
			System.out.println("[code]");
			for (int i = 0; i <= 92; i++) {
				Element songElement = (Element) packetElements.get(i);
				String name = songElement.getAttributeValue("id");
				String id = songElement.getAttributeValue("type");

				System.out.println("public final static int " + name + " = " + id + ";");
			}
			System.out.println("[/code]");
		} catch (JDOMException e) {
			System.out.println("JDOM Fuked u.");
		} catch (IOException e) {
			System.out.println("U fuked u.");
		}
	}
}
