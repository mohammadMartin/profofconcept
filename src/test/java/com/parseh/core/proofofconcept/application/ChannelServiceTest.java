package com.parseh.core.proofofconcept.application;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

@SpringBootTest
@Rollback
public class ChannelServiceTest {
    @Autowired
    private ChannelService channelService;

    @Test
    void testChannelApi() {
        channelService.allUserChannels(1, 10);
    }
}
