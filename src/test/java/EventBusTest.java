/*
 * Copyright 2020-2022 NatroxMC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import de.natrox.eventbus.EventBus;
import de.natrox.eventbus.EventListener;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EventBusTest {

    @Test
    public void test() {
        EventBus eventBus = EventBus.create();

        EventListener<TestEvent> listener = event -> System.out.println("Test");

        assertFalse(eventBus.listening(listener));
        eventBus.register(TestEvent.class, listener);
        assertTrue(eventBus.listening(listener));

        eventBus.call(new TestEvent());

        eventBus.unregister(listener);
        assertFalse(eventBus.listening(listener));
    }

}
