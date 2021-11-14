const express = require("express");
const axios = require("axios");
const app = express();

let cache = { data: [], timestamp: 0 };
const minute = 2;

app.listen(3000, () => {
  console.log("app listening at port 3000");
});

app.get("/", async function (req, res) {
  if (
    cache.timestamp === 0 ||
    new Date().getTime() - cache.timestamp > 60 * 1000 * minute
  ) {
    axios.get("http://worldtimeapi.org/api/timezone/").then((response) => {
      cache.data = response.data;
      cache.timestamp = new Date().getTime();
    });
  }

  res.status(200).send(cache);
});
