package com.saucelabs.appium;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.interactions.HasTouchScreen;
import org.openqa.selenium.interactions.TouchScreen;
import org.openqa.selenium.remote.RemoteTouchScreen;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

import java.net.URL;

public class SelendroidDriver extends AndroidDriver implements HasTouchScreen
{
  public RemoteTouchScreen touch;

  public SelendroidDriver(URL remoteAddress,
                          Capabilities desiredCapabilities) {
    super(remoteAddress, desiredCapabilities);
    touch = new RemoteTouchScreen(getExecuteMethod());
  }

  public TouchScreen getTouch() {
    return touch;
  }
}