import scala.util.matching.Regex
import org.jsoup.Jsoup
import org.jsoup.nodes.Document

import scala.collection.mutable.ArrayBuffer
import scala.jdk.CollectionConverters._

object Scrape extends App {
  // this needs to be in a monad
  val doc: Document = Jsoup.connect("https://python.org").get()
  println(doc.title()) // title of the web page
  println(doc.select("#mp-itn")) // css selector #mp-itn class

  // #id .class tag
  println(doc.select("a")) // all a tags)

  // all text
  val words = for (word <- doc.select("a").asScala) yield word.text
  println(words)

  // possibly a web crawler that can come from this?
  val links = for (link <- doc.select("a").asScala) yield link.attr("href")
  println(links)
}
