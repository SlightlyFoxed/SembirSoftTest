package com.globalsqa;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigFactory;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "system:env",
        "file:src/main/resources/credentials.properties"
})
public interface ConfigProps extends Config {
    ConfigProps conf = ConfigFactory.create(ConfigProps.class);

    @Key("required.balance")
    String requiredBalance();

}
