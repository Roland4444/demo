
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


public class MyWebSocket extends WebSocketController  {

    public static void write (String data) throws IOException{
        FileWriter sw = new FileWriter("data",true);
        sw.write(data+"\r\n");
        sw.close();
    }

    public static void hello(String action) throws InterruptedException,  IOException  {
         if (action.equals("info")){
         outbound.send("<h4>Привет всем! Добро пожаловать в ИТ проект Roman1 Tech. Сам проект Roman1 Tech - мой стартап, меня зовут Роман, я из города Астрахань. В Roman1 Tech под заказ разрабатываются различные информационные продукты и оказываются ИТ уcлуги. Перечень услуг описан в разделе Услуги.</h54");

     }


     if (action.equals("services")){
            outbound.send("В Roman1 под заказ изготовляются сайты-визитки, различные сайты, возможно постороение интернет магазинов. Данный вид работ может предоставляться удаленно, чтобы начать перейдите в раздел \"Оставить заявку\". Также (в городе Астрахань), осуществляется ремонт физический, такие как замена разбитых матриц ноутбуков, чистка кулеров, замена термопаст у ноутбуков. По этому поводу можно обратиться напрямую используя данные с раздела контакты или также \"Оставить заявку\".");

     }

        if (action.equals("faq")){
            outbound.send("<ul>\n" +
                    "      <li> <h4> Что из себя представляет данный сайт? Какие цели у данного стартапа.</h6></li>\n" +
                    "           <p> Данный сайт помогает развитию ИТ технологии и науки в частности, предоставляя любые услуги, которые способен предоставлять\n" +
                    "             на данный момент. По мере развития цели, области, услуги и продукты моргут расширяться.\n" +
                    "      <li> <h4> Какие услуги на данный момент предоставляются?</h6></li>\n" +
                    "          <p> На данный момент предоставляются простые сайты под заказ, возможно написание небольших программ под заказ, в том числе\n" +
                    "            студенческие работы. Доступна также раскрутка сайтов, их поднятие в поиске яндекса и гугла. Оплата принимается биткоинами, Qiwi переводами, WebMoney, банковским переводом.\n" +
                    "          <br>В городе Астрахань может производится ремонт компьютеров, подбор, модернизация комплектующих, а также вопросы связанные с компьютерной\n" +
                    "            безоапасностью и очисткой от вирусов. Оплата такая же что и при удаленном заказе.\n" +
                    "      <li> <h4> Необходима ли предоплата?</h6></li>\n" +
                    "          <p> Предоплата при удаленном заказе необходима, 25% от оговоренной суммы. При ремонте компьютера необходимо оплатить полностью сумму\n" +
                    "             на  необходимые для ремонта запчасти, остальное -  потом.\n" +
                    "      <li> <h4> Даете ли Вы какиенибудь гарантии? </h6></li>\n" +
                    "        <p> Гарантия на физический ремонт, техническое обслуживание 6 месяцев. По окончанию ремонта выдается электронный чек.\n" +
                    "      <li> <h4> Есть ли Вы в соцсетях? </h6></li>\n" +
                    "        <p> Ссылка на мою личную страницу Вконтакте https://vk.com/roland_x, скоро будет группа.\n" +
                    "\n");

        }


        if (action.equals("contacts")){
            outbound.send("Контактный телефон +79608607763, email <a href=\"mailto:xnucleargeminix@aol.com\"> xnucleargeminix@aol.com</a><br>" +
                    "Вконтакте: <a href=\"https://vk.com/roland_x\" <i class=\"fa fa-vk\" aria-hidden=\"true\"></i> </a><br>"+
                    "Facebook: <a href=\"https://www.facebook.com/roman.pastushkov\" <i class=\"fa fa-facebook\" aria-hidden=\"true\"></i> </a>"

                   );

        }


        if (action.equals("portfolio")){
            outbound.send("<div id=\"item1\" ><h4 >BUYLORD.XYZ</h4><br><a  target=\"_blank\" href=\"http://buylord.xyz\"><img  width=\"35%\" src=\"public/images/buylord.xyz.png\"></a>");

        }

        if (action.equals("prices")){
            outbound.send("<h3>Цены предоставляются по запросу. Опишите свою задачу в разделе Оставить заявку.");

        }


        if (action.equals("feedback")){
            outbound.send("<div class=\"jumbotron\"   >\n" +
                    "  <h3>Если хотите оставить отзыв или пожелание:</h3>\n" +
                    "<label for=\"basic-url\"></label>" +
                    "<div class=\"input-group\">\n" +
                    "<label for=\"basic-url\">Имя</label>\n" +
                    "<div id = \"name123\">"+
                    "  <input  id = \"name1\" type=\"text\" class=\"form-control\" placeholder=\"Ваше имя\" aria-describedby=\"basic-addon1\"><br>\n" +
                    "</div></div>\n" +
                    "<label for=\"basic-url\">Комментарий</label>\n" +
                    " <div id=\"comment123\">"+
                    "<textarea   id=\"comment1\" rows=\"10\" class=\"form-control\" placeholder=\"Message\"></textarea></div>"+
                    "<button  onclick=\"feedback()\" class=\"form-control\" type=\"button\" class=\"btn btn-info\">Отправить</button>"+ "</div></div>" );

        }

        if (action.equals("request")) {
            outbound.send("<div class=\"jumbotron\"   >\n" +
                    "  <h3>Здесь можно оставить заявку:</h3>\n" +
                    "<label for=\"basic-url\"></label>" +
                    "<div class=\"input-group\">\n" +
                    "<label for=\"basic-url\">Электронная почта</label>\n" +
                    "<div id = \"name123\">"+
                    "  <input  id = \"email\" type=\"text\" class=\"form-control\" placeholder=\"example@example.com\" aria-describedby=\"basic-addon1\">" +

                    "</div></div>\n" +
                    "<label for=\"basic-url\">Опишите детально характер заказа</label>\n" +
                    " <div id=\"comment123\">"+
                    "<textarea   id=\"reqdetails\" rows=\"10\" class=\"form-control\" placeholder=\"Message\"></textarea></div>"+
                    "<button  style=\"background: red; color:white\" onclick=\"request()\" class=\"form-control\" type=\"button\" class=\"btn btn-info\">Отправить</button>"+ "</div></div>" );
        }


        if (action.equals("showrequests")){
            outbound.send("Привет всем! Добро пожаловать в ИТ проект Roman1 Tech. Сам проект Roman1 Tech - мой стартап, меня зовут Роман, я из города Астрахань. В Roman1 Tech под заказ разрабатываются различные информационные продукты и оказываются ИТ уcлуги. Перечень услуг описан в разделе Услуги.");

        }



    }
}
