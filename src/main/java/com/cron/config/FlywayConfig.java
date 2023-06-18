package com.cron.config;

import org.flywaydb.core.Flyway;

public class FlywayConfig {
        public static void migrate(String url) {
            Flyway load = Flyway.configure().dataSource(url, "", "").load();
            load.migrate();
        }
}
