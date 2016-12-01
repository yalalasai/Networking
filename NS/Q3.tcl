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

set duplex-link $n0 $n2 5Mb 10ms DropTail
set duplex-link $n1 $n2 0.5Mb 10ms DropTail
set duplex-link $n2 $n3 1.5Mb 10ms DropTail

set tcp0 [new Agent/TCP]
$ns attach-agent $n0 $tcp0
set ftp0 [new Application/FTP]
$ftp0 attach-agent $tcp0

set tcp1 [new Agent/TCP]
$ns attach-agent $n1 $tcp1
set ftp1 [new Application/FTP]
$ftp1 attach-agent $tcp1

set tcpsink0 [new Agent/TCPSink]
$ns attach-agent $n3 $tcpsink0

set tcpsink1 [new Agent/TCPSink]
$ns attach-agent $n3 $tcpsink1

$ns connect $tcp0 $tcpsink0
$ns connect $tcp1 $tcpsink1

$ns at 1.0 "$ftp0 start"
$ns at 2.0 "$ftp1 start"
$ns at 7.0 "finish"

$ns run



























