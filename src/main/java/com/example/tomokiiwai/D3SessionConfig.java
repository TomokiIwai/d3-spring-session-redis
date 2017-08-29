package com.example.tomokiiwai;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.session.data.redis.config.ConfigureRedisAction;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.web.http.CookieSerializer;
import org.springframework.session.web.http.DefaultCookieSerializer;

/**
 * セッション設定
 */
@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 5 * 60) // 5分
public class D3SessionConfig {
	//
	// @EnableRedisHttpSession
	//
	// RedisOperationsSessionRepository（Redis操作を規定するRedisOperationを用いたSessionRepository実装）と
	// SessionRepositoryFilter（SessionのハンドリングをSpring-Sessionに移譲するフィルタ）を有効にしてくれる
	//

	/**
	 * ElastiCacheを使用するため、SpringSessionがRedisに対してCONFIGコマンドを実行しないように設定します。
	 *
	 * @return {@link ConfigureRedisAction}
	 */
	@Bean
	public ConfigureRedisAction configureRedisAction() {
		return ConfigureRedisAction.NO_OP;
	}

	/**
	 * Redis格納するセッション情報をJSON形式にします。
	 *
	 * @return {@link RedisSerializer}
	 */
	@Bean
	public RedisSerializer<Object> springSessionDefaultRedisSerializer() {
		//
		// Spring Securityを併用する場合には、Jackson拡張モジュールを利用する
		//
//		ObjectMapper objectMapper = new ObjectMapper();
//		objectMapper.registerModules(SecurityJackson2Modules.getModules(classLoader));
//		return new GenericJackson2JsonRedisSerializer(objectMapper);

		return new GenericJackson2JsonRedisSerializer();
	}

	/**
	 * Cookieをカスタマイズします。
	 *
	 * @return {@link CookieSerializer}
	 */
	@Bean
	public CookieSerializer cookieSerializer() {
		final DefaultCookieSerializer serializer = new DefaultCookieSerializer();
		serializer.setCookieName("D3SESSIONID");
		return serializer;
	}
}
