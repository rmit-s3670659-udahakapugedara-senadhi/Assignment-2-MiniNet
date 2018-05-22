import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MiniNetTest {

	@Test //testing user creation
	void test() {
		Profile Allice = new Profile("Allice","F","25","VIC");
		assertEquals("Adult",Allice.getType());
	}

}
