package controllers;

import java.io.File;

import play.*;
import play.mvc.*;
import play.mvc.Http.MultipartFormData;
import play.mvc.Http.MultipartFormData.FilePart;

import views.html.*;

public class SongController extends Controller {

    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }
    
    public static Result songUpload()
    {
    	MultipartFormData body = Controller.request().body().asMultipartFormData();
    	FilePart song = body.getFile("file");
    	if (song != null) 
    	{
    		String fileName = song.getFilename();
    		String contentType = song.getContentType(); 
    		File file = song.getFile();
    		return ok("File uploaded.");
    	} 
    	else 
    	{
    		return badRequest("An error has occurred.");    
    	}
    }

}
