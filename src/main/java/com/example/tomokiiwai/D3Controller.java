package com.example.tomokiiwai;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

/**
 * コントローラー
 *
 * @author tomoki.iwai
 */
@Controller
public class D3Controller {
	/**
	 * トップページ
	 */
	@RequestMapping("/")
	@ResponseBody
	public String index(HttpSession session) {
		final HashMap<String, String> map = new HashMap<>();
		map.put("hoge", "fuga");
		session.setAttribute("hoge", map);

		return "Hello World";
	}
}
