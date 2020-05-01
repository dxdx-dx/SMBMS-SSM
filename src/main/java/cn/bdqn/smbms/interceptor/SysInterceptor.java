package cn.bdqn.smbms.interceptor;

import cn.bdqn.smbms.pojo.User;
import cn.bdqn.smbms.util.Constants;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 拦截器
 *
 * @author Matrix
 * @date 2020/4/30 9:29
 */
public class SysInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(Constants.USER_SESSION);
        if (user == null) {
            response.sendRedirect(request.getContextPath() + "/401.jsp");
            return false;
        } else {
            return true;
        }
    }
}
