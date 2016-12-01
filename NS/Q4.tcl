set ns [network Simulator]
set tracefile [open out.tr w]

$ns trace-all $tracefile

set nf [open out.nam w]
$ns namtrace-all $nf

proc finish{} {
    global ns tracefile nf
    $ns flush-trace
    close $nf
    close $tracefile
    exec nam out.nam &
    exit 0
}

set n0 [$ns node]
set n1 [$ns node]
set n2 [$ns node]
set n3 [$ns node]
set n4 [$ns node]

set simplex-link $n0 $n2 100Mb 5ms DropTail
set simplex-link $n2 $n3 54Mb  10ms DropTail
set duplex-link  $n1 $n2 100Mb 5ms DropTail
set duplex-link  $n2 $n4 54Mb  10ms DropTail

set udp0 [new Agent/UDP]
$ns attach-agent $n0 $udp0

set cbr0 [new Appplication/Traffic/CBR]
$cbr0 attach-agent $udp0

set tcp0 [new Agent/TCP]
$ns attach-agent $n1 $tcp0

set ftp0 [new Appplication/FTP]
$ftp0 attach-agent $tcp0

set tcpsink0 [new Agent/TCPSink]
$ns attach-agent $n4 $tcpsink0

set null0 [new Agent/Null]
$ns attach-agent $n3 $null0

$ns connect $udp0 $null0
$ns connect $tcp0 $tcpsink0

$ns at 1.0 "cbr0 start"
$ns at 3.0 "ftp0 start"
$ns at 7.0 "finish"

$ns run 














