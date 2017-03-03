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


public class feedbackSocket extends WebSocketController  {
    public static String name;
    public static String comment;
    public static String info;

    public static void feedback(String param) throws InterruptedException, IOException  {
        Date d = new Date();
        SimpleDateFormat format1 = new SimpleDateFormat("dd.MM.yyyy hh:mm");
                System.out.print("inside feedback");
        FileWriter sw = new FileWriter("feedbacks",true);
        sw.write("feedback>>>>"+"\r\n");
     //   System.out.print(param);
        name = param.substring(0, param.indexOf("<==>"));
        sw.write("name>>>>>>>>>>>>>>>>>"+name+"\r\n");
        comment = param.substring(param.indexOf("<==>")+4);
        sw.write("comment>>>>>>>>>>"+ comment+"\r\n");
       // sw.write("comment>"+comment+"\r\n");
        //sw.write("name>>>>"+name+"comment>>>>"+comment+"date>>>>"+format1.format(d)+"\r\n");
        sw.close();
        outbound.send("<h2>СПАСИБО!<br></h3>"+
                "<h3>Ваш отзыв будет выглядеть следующим образом</h4><br>"+
                "<div class=\"panel panel-info\" style=\"font-family: museosans2;\" ><h4 ><i>"+name+" написал(а): </i> </h4><br><h4><i>"+comment+"</i></h4></div>");

    }
}
