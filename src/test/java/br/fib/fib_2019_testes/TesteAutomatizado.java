package br.fib.fib_2019_testes;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteAutomatizado {
	@Test
	public void deveAdicionarUmCorrentista() {
	   System.setProperty("webdriver.chrome.driver","E:\\selenium\\chromedriver.exe");
	   WebDriver driver = new ChromeDriver();
	   driver.get("http://192.168.5.115:9098/calculator/new");

	   WebElement nome = driver.findElement(By.name("name"));
	   WebElement dependents = driver.findElement(By.name("dependents"));
	   WebElement timeToWork = driver.findElement(By.name("timeToWork"));
	   WebElement salaryHour = driver.findElement(By.name("salaryHour"));
	   
	   nome.sendKeys("Marcos Eduardo");
	   dependents.sendKeys("2");
	   timeToWork.sendKeys("8");
	   salaryHour.clear();
	   salaryHour.sendKeys("40.50");
	   

	   WebElement botaoSalvar = driver.findElement(By.id("salvar"));
	   botaoSalvar.click();

	   //verifica se gravou	
	   boolean achouNome = driver.getPageSource().contains("Marcos Eduardo");
	   //boolean achou = driver.getPageSource().contains("manoel.silva@mailinator.com");

	   assertTrue(achouNome);
       driver.close();
	   //assertTrue(achouEmail);

	   
	}
	@Test
	public void verificaValidacaodeValores() {
		   System.setProperty("webdriver.chrome.driver","E:\\selenium\\chromedriver.exe");
		   WebDriver driver = new ChromeDriver();
		   driver.get("http://192.168.5.115:9098/calculator/new");

		   WebElement nome = driver.findElement(By.name("name"));
		   WebElement dependents = driver.findElement(By.name("dependents"));
		   WebElement timeToWork = driver.findElement(By.name("timeToWork"));
		   WebElement salaryHour = driver.findElement(By.name("salaryHour"));
		   
		   nome.sendKeys("Marcos Eduardo");
		   dependents.sendKeys("0");
		   timeToWork.sendKeys("0");
		   salaryHour.clear();
		   salaryHour.sendKeys("0");
	
		   WebElement botaoSalvar = driver.findElement(By.id("salvar"));
		   botaoSalvar.click();
	
		   boolean valoresPositivos = driver.getPageSource().contains("deve ser maior ou igual a 1");
		   assertTrue(valoresPositivos);
		   
	       driver.close();
	}
}
