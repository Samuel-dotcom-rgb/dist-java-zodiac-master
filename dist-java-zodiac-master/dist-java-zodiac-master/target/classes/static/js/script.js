/* Variables */
var videoPlayer,
    video,
    playlist,
    source,
    linkList = [],
    videoDirectory = 'video/',
    currentVideo = 0,
    allLinks,
    videoCount;

(function () {
    videoPlayer = document.getElementById('video-player');
    video = videoPlayer.getElementsByClassName('fullscreen-bg__video')[0];
    playlist = videoPlayer.getElementsByClassName('fullscreen-bg__playlist')[0];
    source = video.getElementsByTagName('source')[0];
    allLinks = playlist.children;
    videoCount = allLinks.length;

    // Save all video sources from playlist
    for (let i = 0; i < videoCount; i++) {
        let filename = allLinks[i].href;
        linkList[i] = filename.match(/([^\/]+)(?=\.\w+$)/)[0];
    }

    /**
     * Play next video
     */
    video.addEventListener('ended', function () {
        allLinks[currentVideo].classList.remove('current-video');

        let nextVideo = currentVideo + 1;
        if (nextVideo >= videoCount) {
            nextVideo = 0;
        }
        playVideo(nextVideo);
    });
});

/**
 * Load and play video
 * @param  int index Video index
 */
function playVideo(index) {
    allLinks[index].classList.add('current-video');
    currentVideo = index;

    source.src = videoDirectory + linkList[index] + '.mp4';

    video.load();
    video.play();
}