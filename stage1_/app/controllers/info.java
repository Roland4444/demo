package controllers;
import play.*;
import play.mvc.*;

import java.util.*;

import models.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.Vector;


public class info extends WebSocketController  {
    public static String name;
    public static String comment;
    public static String info;
    public static void info(String req) throws InterruptedException, IOException  {
        if (req.equals("feedbacks")){
            List<String> names = new ArrayList();
            List<String> comments = new ArrayList();
            int _counter=0;
            String nameItem;
            String commentItem;
            Scanner in1 = new Scanner(new File("feedbacks"));
            String str = "";
            while(in1.hasNext()){
                str = in1.nextLine() + "\r\n";
                int posName = str.indexOf("name>>>>>>>>>>>>>>>>");
                int posCom = str.indexOf("comment>>>>>>>>>>");
                if (posName != -1) {
                    nameItem = str.substring(posName+21);
                    names.add(_counter, nameItem);
                }
                if (posCom != -1) {
                    commentItem= str.substring(posCom+17);
                    comments.add(_counter++,commentItem);
                }

            };
            for (int z=0;z<_counter;z++){
                //System.out.print(names.get(z)+comments.get(z));
            }
            //System.out.print(_counter);

            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(" <div id=\"myCarousel\" class=\"carousel slide\" data-ride=\"carousel\">\n");
            stringBuilder.append("<ol class=\"carousel-indicators\">");
            stringBuilder.append("    <li data-target=\"#myCarousel\" data-slide-to=\""+0+"\" class=\"active\"></li>\n");
            for (int z=1;z<_counter;z++){
                stringBuilder.append("    <li data-target=\"#myCarousel\" data-slide-to=\""+z+"\" ></li>\n");
            //    System.out.print(names.get(z)+comments.get(z));
            }
            stringBuilder.append( "  </ol>");
            stringBuilder.append(" <div class=\"carousel-inner\" role=\"listbox\">");
            stringBuilder.append("<div class=\"item active\">");
            stringBuilder.append("<h3>"+names.get(0)+" написал</h3><br>"+comments.get(0)+"</div>");
            for (int z=1;z<_counter;z++){
                stringBuilder.append("  <div class=\"item\">"+"<h3>"+names.get(z)+" написал</h3><br>"+comments.get(z)+"</div>");
            }

            stringBuilder.append("</div>");
            stringBuilder.append(" </div>");
            String finalString = stringBuilder.toString();
             outbound.send(finalString);
        }
    }
}

