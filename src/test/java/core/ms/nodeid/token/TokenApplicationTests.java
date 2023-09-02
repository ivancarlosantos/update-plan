package core.ms.nodeid.token;

import core.ms.nodeid.token.model.Token;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class TokenApplicationTests {

	@Test
	void test() {
			UUID id = UUID.randomUUID();
			String token = "meuToken";
			LocalDateTime timestamp = LocalDateTime.now();

			Token object = new Token(id, token, timestamp);

			assertNotNull(object);
			assertEquals(id, object.getId());
			assertEquals(token, object.getToken());
			assertEquals(timestamp, object.getTimestamp());
	}
}
