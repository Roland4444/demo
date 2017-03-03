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


public class requestSocket extends WebSocketController  {
    public static String email;
    public static String comment;
    public static String info;

    public static void request(String param) throws InterruptedException, IOException  {
        outbound.send("<h2>Заказ принят ;-) ");
        System.out.print(param);

        Date d = new Date();
        SimpleDateFormat format1 = new SimpleDateFormat("dd.MM.yyyy hh:mm");
        FileWriter sw = new FileWriter("request",true);
        sw.write("request>>>>"+format1.format(d)+"\r\n");
        //   System.out.print(param);
        email = param.substring(0, param.indexOf("<==>"));
        sw.write("email>>>>>>>>>>>>>>>>>"+email+"\r\n");
        comment = param.substring(param.indexOf("<==>")+4);
        sw.write("comment>>>>>>>>>>"+ comment+"\r\n");
        // sw.write("comment>"+comment+"\r\n");
        //sw.write("name>>>>"+name+"comment>>>>"+comment+"date>>>>"+format1.format(d)+"\r\n");
        sw.close();

    }
}