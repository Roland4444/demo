package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class Application extends Controller {

    public static void index() {
        render();
    }
    public static void info() {render();}
    public static void spa(){render();}
    public static void en(){render();}
    public static void es(){render();}
    public static void ru(){render();}

}