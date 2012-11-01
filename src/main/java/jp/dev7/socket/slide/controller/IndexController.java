package jp.dev7.socket.slide.controller;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

public class IndexController extends Controller {

    @Override
    public Navigation run() throws Exception {
        // UserService userService = UserServiceFactory.getUserService();
        // if (userService.getClass() == null) {
        // return redirect(userService.createLoginURL("/"));
        // }

        return forward("index.jsp");
    }
}
