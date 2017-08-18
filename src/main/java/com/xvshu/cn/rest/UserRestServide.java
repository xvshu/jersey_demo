package com.xvshu.cn.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 * Created by xvshu on 2017/8/16.
 */
@Path("/user")
public class UserRestServide {

    @GET
    @Path("/{from}/{userName}/{passWord}")
    @Produces("text/plain;charset=UTF-8")
    public String sayHello2UserByText(@PathParam("userName") String username,@PathParam("passWord") String passWord,@PathParam("from") String from) {
        String result = "false";

        System.out.println("==>rest/from:"+String.valueOf(from)+" user:"+String.valueOf(username)+" pass:"+String.valueOf(passWord));
        username=username.trim();
        passWord=passWord.trim();
        if(username.equals("admin") && passWord.equals("admin")){
            result="true";
        }
        return result;
    }
}
