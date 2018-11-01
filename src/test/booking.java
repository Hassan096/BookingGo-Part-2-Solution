package test;

import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@Path("/booking")
public class booking {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String makeBooking(@QueryParam("pickup") String pickup, @QueryParam("dropoff") String dropoff, @QueryParam("noOfPassengers") int noOfPassengers ) throws IOException 
	{
	      String inputLine = "";
	      String inputLine2 = "";
	      String inputLine3 = "";
	      String totalInput = "";
	      String CurrentLine;
	      Object pricePrevious = "999999999";
	      Object priceNow = "999999999";
	      Object carAvailable = null;
	      Object supplierID = null;
	      Object pricePrevious1 = "999999999";
	      Object priceNow1 = "999999999";
	      Object carAvailable1 = null;
	      Object supplierID1 = null;
	      Object pricePrevious2 = "999999999";
	      Object priceNow2 = "999999999";
	      Object carAvailable2 = null;
	      Object supplierID2 = null;
	      Object pricePrevious3 = "999999999";
	      Object priceNow3 = "999999999";
	      Object carAvailable3 = null;
	      Object supplierID3 = null;
	      Object pricePrevious4 = "999999999";
	      Object priceNow4 = "999999999";
	      Object carAvailable4 = null;
	      Object supplierID4 = null;
	      Object pricePrevious5 = "999999999";
	      Object priceNow5 = "999999999";
	      Object carAvailable5 = null;
	      Object supplierID5 = null;
	      BufferedReader br = null;

	      //take pickup and dropoff locations as arguments
	      String pickupLoc = pickup;
	      String dropoffLoc = dropoff;
	      int numberOfPassengers = noOfPassengers;
	           
	      //define the URL for connection
	      URL myURL = new URL("https://techtest.rideways.com/dave/" + "?pickup=" + pickupLoc + "&dropoff=" + dropoffLoc);
	      URL myURL2 = new URL("https://techtest.rideways.com/eric/" + "?pickup=" + pickupLoc + "&dropoff=" + dropoffLoc);
	      URL myURL3 = new URL("https://techtest.rideways.com/jeff/" + "?pickup=" + pickupLoc + "&dropoff=" + dropoffLoc);
	      
	      //open the connection to the URL
	      HttpURLConnection connection = (HttpURLConnection)myURL.openConnection();
	      connection.setConnectTimeout(2000);
	      HttpURLConnection connection2 = (HttpURLConnection)myURL2.openConnection();
	      connection2.setConnectTimeout(2000);
	      HttpURLConnection connection3 = (HttpURLConnection)myURL3.openConnection();
	      connection3.setConnectTimeout(2000);
	      
	      //Get the response code
	      int responseCode = connection.getResponseCode();
	      int responseCode2 = connection2.getResponseCode();
	      int responseCode3 = connection3.getResponseCode();
	      
	      //System.out.println("The response code is " + responseCode2);
	      
	      //if connection fails throw an exception
	      if (responseCode != 200)
	      {
	        throw new RuntimeException("Response code is: " +responseCode);
	      }
	      
	      else{
	          Scanner scan = new Scanner(myURL.openStream());
	          while (scan.hasNext())
	              inputLine += scan.nextLine();
	            //System.out.println(inputLine);
	          scan.close();
	      }
	      
	      //if connection fails throw an exception
	      if (responseCode2 != 200)
	      {
	        throw new RuntimeException("Response code is: " +responseCode2);
	      }
	      
	      else{
	          Scanner scan = new Scanner(myURL2.openStream());
	          while (scan.hasNext())
	              inputLine2 += scan.nextLine();
	            //System.out.println(inputLine2);
	          scan.close();
	      }
	      
	      //if connection fails throw an exception
	      if (responseCode3 != 200)
	      {
	        throw new RuntimeException("Response code is: " +responseCode3);
	      }
	      
	      else{
	          Scanner scan = new Scanner(myURL3.openStream());
	          while (scan.hasNext())
	              inputLine3 += scan.nextLine();
	            //System.out.println(inputLine3);
	          scan.close();
	      }
	      
	      //combine all the data from the three apis and put lines inbetween so we can parse them
	      totalInput = inputLine + "\n" + inputLine2 + "\n" + inputLine3;
	      System.out.println(totalInput);
	  return totalInput;
	}


}
