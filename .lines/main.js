const fs = require('fs')

const html = fs.readFileSync('./play.html').toString().split('\n')

// const html = [
// 	"<A NAME=speech1><b>First Witch</b></a>",
// "<blockquote>",
// "<A NAME=1.1.1>When shall we three meet again</A><br>",
// "<A NAME=1.1.2>In thunder, lightning, or in rain?</A><br>",
// "</blockquote>",
// ]

let c = 0
let currentName = ""
while (html.length != c) { 
	if (html[c] == "" || html[c] == undefined) {
		c++
		continue
	}

	if (html[c].startsWith('<A NAME=speech')) {
		currentName = html[c].replace(new RegExp("<A NAME=speech\\d+><b>", 'g'), "").replace(new RegExp("</b></a>", "g"), "")
	} else if (html[c].startsWith('<A NAME=')) {
		fs.appendFileSync('./lines.txt', html[c].replace(new RegExp("<A NAME=\\d+.\\d+.\\d+>", "g"), "").replace(new RegExp("</A><br>", "g"), "").replace(/\t/g, "  ") + "\t" + currentName + "\n")
	}

	c++;
}